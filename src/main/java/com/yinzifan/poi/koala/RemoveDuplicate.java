package com.yinzifan.poi.koala;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.beust.jcommander.internal.Maps;
import com.google.common.collect.Sets;

public class RemoveDuplicate {

    private FormulaEvaluator evaluator;
    private DataFormatter formatter;
    private Workbook wb;
    private Workbook result;
    private Map<String, Stack<Integer>> blankRowIndexMap;

    public RemoveDuplicate(Workbook wb) {
        this.wb = wb;
        this.result = new XSSFWorkbook();
        blankRowIndexMap = new HashMap<>();
        this.init();
    }

    public void parse() {
//        for (int i = 0; i < wb.getNumberOfSheets(); i++) {
            Sheet currentSheet = wb.getSheet("全国表");
            Sheet targetSheet = result.createSheet(currentSheet.getSheetName());
            blankRowIndexMap.put(targetSheet.getSheetName(), new Stack<>());
            copyRow(currentSheet.getRow(0), targetSheet.createRow(0));
            calculate(currentSheet, targetSheet);
            removeBlankRow(targetSheet);
//        }
    }

    public void outputToFile(File file) {
        try {
            System.out.println(String.format("准备输出到文件%s", file.getCanonicalPath()));
            result.write(new FileOutputStream(file));
            System.out.println("文件输出成功!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(result);
            IOUtils.closeQuietly(wb);
        }
    }

    private void calculate(Sheet currentSheet, Sheet targetSheet) {
        System.out.println("开始执行去重操作");
        Map<RecordInfo, RecordInfo> map = Maps.newHashMap();
        Map<Integer, String> titleIndexMapping = mapping(currentSheet.getRow(0));
        Stack<Integer> stack = blankRowIndexMap.get(targetSheet.getSheetName());
        for (int i = 1; i < currentSheet.getPhysicalNumberOfRows(); i++) {
            Row row = currentSheet.getRow(i);
            RecordInfo info = assembleRecordInfo(row, titleIndexMapping);
            if (map.containsKey(info) && "临床".equals(info.getType())) {
                RecordInfo recordInfo = map.get(info);
                System.out.println();
                System.out.println(String.format("存在重复记录: 第 %s 和第 %s 行重复, 金额为: %s (第 %s 行), %s (第 %s 行)",
                        info.getRowIndexInExcel(), recordInfo.getRowIndexInExcel(), info.getPayment(),
                        info.getRowIndexInExcel(), recordInfo.getPayment(), recordInfo.getRowIndexInExcel()));
                recordInfo.setPayment(recordInfo.getPayment().add(info.getPayment()));
                System.out.println(
                        String.format("将第 %s 记录的金额更新为: %s ", recordInfo.getRowIndexInExcel(), recordInfo.getPayment()));
                System.out.println(String.format("更新后的结果为: %s", recordInfo.toString()));
                updateRow(targetSheet.getRow(recordInfo.getRowIndex()), info, recordInfo.getPayment().doubleValue());
                stack.push(info.getRowIndex());
            } else {
                info.setRowIndex(i);
                map.put(info, info);
                Row targetValueRow = targetSheet.createRow(i);
                copyRow(row, targetValueRow);
            }
        }
    }

    private void init() {
        evaluator = wb.getCreationHelper().createFormulaEvaluator();
        formatter = new DataFormatter();
    }

    private void removeBlankRow(Sheet targetSheet) {
        Stack<Integer> stack = blankRowIndexMap.get(targetSheet.getSheetName());
        while (!stack.isEmpty()) {
            Integer index = stack.pop();
            System.out.println(String.format("检测到%s行是空行, 开始删除...", index + 1));
            targetSheet.shiftRows(index + 1, targetSheet.getLastRowNum(), -1);
            System.out.println(String.format("第%s行删除成功", index + 1));
        }
    }

    private void updateRow(Row row, RecordInfo info, double payment) {
        Cell cell = row.getCell(info.getPaymentCellIndex());
        cell.setCellValue(payment);
    }

    private RecordInfo assembleRecordInfo(Row row, Map<Integer, String> mapping) {
        RecordInfo info = new RecordInfo();
        for (int i = 0; i < row.getLastCellNum(); i++) {
            if (!mapping.containsKey(i))
                continue;
            String value = formatter.formatCellValue(row.getCell(i), evaluator);
            String title = mapping.get(i);
            switch (title) {
            case "订单号":
                info.setOrderId(value);
                break;
            case "销售代表":
                info.setSales(value);
                break;
            case "月份":
                info.setPerformanceMonth(value);
                break;
            case "收费金额":
                if (StringUtils.isBlank(value)) value = "0";
                info.setPaymentCellIndex(i);
                info.setPayment(new BigDecimal(value));
                break;
            case "性质":
                info.setType(value);
            case "病人姓名":
                info.setPatientName(value);
                break;
            default:
                break;
            }
        }
        info.setRowIndex(row.getRowNum());
        return info;
    }

    private void copyRow(Row row, Row targetRow) {
        for (int i = 0; i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            Cell targetCell = null;
            if(cell == null) {
                targetCell = targetRow.createCell(i, Cell.CELL_TYPE_BLANK);
            } else {
                targetCell = targetRow.createCell(i, cell.getCellType());
                targetCell.setCellComment(cell.getCellComment());
            }
            copyCellValue(cell, targetCell);
        }
    }

    private void copyCellValue(Cell cell, Cell targetCell) {
        if (cell == null) {
            targetCell.setCellValue(new String());
            return;
        }
        switch (cell.getCellType()) {
        case Cell.CELL_TYPE_BOOLEAN:
            targetCell.setCellValue(cell.getBooleanCellValue());
            break;
        case Cell.CELL_TYPE_ERROR:
            targetCell.setCellValue(cell.getErrorCellValue());
            break;
        case Cell.CELL_TYPE_FORMULA:
            targetCell.setCellValue(cell.getCellFormula());
            break;
        case Cell.CELL_TYPE_NUMERIC:
            targetCell.setCellValue(cell.getNumericCellValue());
            break;
        case Cell.CELL_TYPE_STRING:
            targetCell.setCellValue(cell.getStringCellValue());
        default:
            break;
        }
    }

    private Map<Integer, String> mapping(Row row) {
        Map<Integer, String> map = new HashMap<>();
        int cellCnt = row.getPhysicalNumberOfCells();
        Set<String> set = Sets.newHashSet("订单号", "销售代表", "月份", "收费金额", "病人姓名", "性质");
        for (int i = 0; i < cellCnt; i++) {
            String columnName = formatter.formatCellValue(row.getCell(i), evaluator);
            if (set.contains(columnName))
                map.put(i, columnName);
        }
        return map;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        RemoveDuplicate removeDuplicate = new RemoveDuplicate(
                new XSSFWorkbook(new FileInputStream("C:\\Users\\Steven.Yin\\Documents\\demo.xlsx")));
        removeDuplicate.parse();
        File result = new File("C:\\Users\\Steven.Yin\\Documents\\result.xlsx");
        if (!result.exists())
            result.createNewFile();
        removeDuplicate.outputToFile(result);
    }
}
