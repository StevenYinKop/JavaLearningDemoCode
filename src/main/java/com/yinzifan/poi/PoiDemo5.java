package com.yinzifan.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @author Cin
 * 单元格合并
 */
public class PoiDemo5 {

	public static void main(String[] args) throws Exception {
		Workbook wb = new HSSFWorkbook(); // 新建Workbook接口
		Sheet sheet1 = wb.createSheet(); // 创建一个sheet 
		sheet1.addMergedRegion(new CellRangeAddress(1,2,3,4));
		FileOutputStream fos = new FileOutputStream(PoiDemo5.class.getSimpleName() + ".xls"); // 创建输出流
		wb.write(fos);
		wb.close();
	}
	
	public static void createCell(Workbook wb, Row row, short column, short halign, short valign) {
		Cell cell = row.createCell(column);
		cell.setCellValue(new HSSFRichTextString("HSSFRichTextString"));
		CellStyle style = wb.createCellStyle();
		style.setAlignment(halign);
		style.setAlignment(valign);
		cell.setCellStyle(style); // 设置到当前单元格中!
	}
	
}
