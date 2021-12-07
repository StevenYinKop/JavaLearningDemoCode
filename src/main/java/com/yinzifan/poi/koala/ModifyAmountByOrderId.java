//package com.yinzifan.poi.koala;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.text.DecimalFormat;
//import java.util.Map;
//
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.FormulaEvaluator;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import com.beust.jcommander.internal.Maps;
//
//public class ModifyAmountByOrderId {
//
//    private static FormulaEvaluator evaluator;
//    private static DataFormatter formatter;
//
//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        DecimalFormat df = new DecimalFormat();
//        df.setMaximumFractionDigits(2);
//        df.setMinimumFractionDigits(0);
//        df.setGroupingUsed(false);
//        SXSSFWorkbook wb = new SXSSFWorkbook(new XSSFWorkbook(new FileInputStream("C:\\Users\\Steven.Yin\\Desktop\\Carina.Hu\\demo2.xlsx")));
//        evaluator = wb.getCreationHelper().createFormulaEvaluator();
//        formatter = new DataFormatter();
//        Sheet mainSheet = wb.getSheet("5.1 明细");
//        Sheet mappingSheet = wb.getSheet("目标数据");
//        Map<String, BigDecimal> orderAndAmountMapping = getOrderAndAmountMapping(mappingSheet);
//        int amountIndex = findIndex("含税收入", mainSheet.getRow(0));
//        int orderIndex = findIndex("订单号", mainSheet.getRow(0));
//        int amountYearIndex = findIndex("收入年份", mainSheet.getRow(0));
//        for (int i = 1; i < mainSheet.getLastRowNum(); i++) {
//            Row row = mainSheet.getRow(i);
//            Cell orderCell = row.getCell(orderIndex);
//            String orderNumber = getValue(orderCell);
//            String amountYear = getValue(row.getCell(amountYearIndex));
//            if (!StringUtils.equals("2020", amountYear)) {
//                System.out.println(String.format("订单号: %s 不在操作范围内(收入年份为: %s", orderNumber, amountYear));
//                continue;
//            }
//            if (orderAndAmountMapping.get(orderNumber) != null) {
//                BigDecimal amount = orderAndAmountMapping.get(orderNumber);
//                row.getCell(amountIndex).setCellValue(df.format(amount));
//                System.out.println("将订单号: " + orderNumber + "的含税金额修改为:" + df.format(amount) + ", 不含税金额修改为: " + df.format(amount.divide(new BigDecimal("1.06"), RoundingMode.HALF_UP)));
//                row.getCell(amountIndex + 1).setCellValue(df.format(amount.divide(new BigDecimal("1.06"), RoundingMode.HALF_UP)));
//            } else {
//                System.out.println("订单号: " + orderNumber + " 不在操作范围内(需要修改的列表中没有这个订单号)");
//            }
//        }
//        File file = new File("C:\\Users\\Steven.Yin\\Desktop\\Carina.Hu\\result.xlsx");
//        if(!file.exists()) file.createNewFile();
////        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(wb, 200);
//        FileOutputStream stream = new FileOutputStream(file);
//        wb.write(stream);;
//        stream .close();
//        wb.close();
//    }
//
//    private static int findIndex(String title, Row row) {
//        for (int i = 0; i < row.getLastCellNum(); i++) {
//            if (title.contentEquals(getValue(row.getCell(i)))) {
//                return i;
//            }
//        }
//        throw new RuntimeException("sheet页中不包含叫做\"" + title + "\"的标题");
//    }
//
//    private static Map<String, BigDecimal> getOrderAndAmountMapping(Sheet mappingSheet) {
//        Map<String, BigDecimal> orderAndAmountMapping = Maps.newHashMap();
//        for (int i = 1; i < mappingSheet.getLastRowNum(); i++) {
//            Row row = mappingSheet.getRow(i);
//            Cell orderCell = row.getCell(findIndex("订单号", row));
//            Cell amountCell = row.getCell(findIndex("新收入", row));
//            orderAndAmountMapping.put(getValue(orderCell),
//                    new BigDecimal(getValue(amountCell)).setScale(2, RoundingMode.HALF_UP));
//        }
//        return orderAndAmountMapping;
//    }
//
//    public static String getValue(Cell cell) {
//        return formatter.formatCellValue(cell, evaluator);
//    }
//}
