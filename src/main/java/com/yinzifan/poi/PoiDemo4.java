package com.yinzifan.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author Cin
 * 单元格边框与颜色
 */
public class PoiDemo4 {

	public static void main(String[] args) throws Exception {
		Workbook wb = new HSSFWorkbook(); // 新建Workbook接口
		Sheet sheet1 = wb.createSheet(); // 创建一个sheet 
		
		Row row = sheet1.createRow(2); // 创建第0行
		Cell cell = row.createCell(1);
		Cell cell2 = row.createCell(2);
		cell2.setCellValue("前景颜色");
		cell.setCellValue(4);
		
		
		CellStyle style = wb.createCellStyle();
		style.setBorderBottom(CellStyle.BORDER_DASH_DOT); // 设置底部边框为点状
		style.setBottomBorderColor(IndexedColors.BLUE.getIndex()); // 设置底部边框颜色为蓝色
		
		style.setBorderLeft(CellStyle.BORDER_THIN); 
		style.setLeftBorderColor(IndexedColors.YELLOW.getIndex()); // 设置左侧边框颜色为黄色
		
		style.setBorderTop(CellStyle.BORDER_THICK); 
		style.setTopBorderColor(IndexedColors.RED.getIndex()); // 设置左侧边框颜色为黄色
		
		style.setBorderRight(CellStyle.BORDER_MEDIUM); 
		style.setRightBorderColor(IndexedColors.PINK.getIndex()); // 设置左侧边框颜色为黄色
		
		style.setFillPattern(CellStyle.SOLID_FOREGROUND); 
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex()); // 添加背景颜色
		cell.setCellStyle(style);
		
		
		style.setFillPattern(CellStyle.SOLID_FOREGROUND); 
		style.setFillForegroundColor(IndexedColors.RED.getIndex()); // 添加背景颜色
		cell2.setCellStyle(style);
		
		FileOutputStream fos = new FileOutputStream(PoiDemo4.class.getSimpleName() + ".xls"); // 创建输出流
		
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
