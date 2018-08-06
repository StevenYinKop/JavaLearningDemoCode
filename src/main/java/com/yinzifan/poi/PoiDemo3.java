package com.yinzifan.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author Cin
 * 对齐方式
 */
public class PoiDemo3 {

	public static void main(String[] args) throws Exception {
		Workbook wb = new HSSFWorkbook(); // 新建Workbook接口
		Sheet sheet1 = wb.createSheet(); // 创建一个sheet 
		Row row = sheet1.createRow(2); // 创建第0行
		row.setHeightInPoints(30);
		createCell(wb, row, (short)0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_BOTTOM);
		createCell(wb, row, (short)1, CellStyle.ALIGN_CENTER_SELECTION, CellStyle.VERTICAL_CENTER);
		createCell(wb, row, (short)2, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_TOP);
		createCell(wb, row, (short)3, CellStyle.ALIGN_RIGHT, CellStyle.VERTICAL_JUSTIFY);
		wb.createSheet("custom name sheet"); // 创建一个sheet(自定义sheet名称)
		FileOutputStream fos = new FileOutputStream(PoiDemo3.class.getSimpleName() + ".xls"); // 创建输出流
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
