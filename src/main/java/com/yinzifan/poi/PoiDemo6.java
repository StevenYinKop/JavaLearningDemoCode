package com.yinzifan.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author Cin
 * 字体设置
 */
public class PoiDemo6 {

	public static void main(String[] args) throws Exception {
		Workbook wb = new HSSFWorkbook(); // 新建Workbook接口
		Sheet sheet1 = wb.createSheet(); // 创建一个sheet 
		Row row = sheet1.createRow(1);
		Font font= wb.createFont();
		font.setFontHeightInPoints((short)24);
		font.setFontName("Courier New");
		font.setItalic(true);
		font.setStrikeout(true);
		
		CellStyle style = wb.createCellStyle();
		
		Cell cell = row.createCell(1);
		cell.setCellValue("test!!test!!test!!test!!");
		style.setFont(font);
		cell.setCellStyle(style);
		FileOutputStream fos = new FileOutputStream(PoiDemo6.class.getSimpleName() + ".xls"); // 创建输出流
		wb.write(fos);
		wb.close();
	}
	
}
