package com.yinzifan.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author Cin
 * 字体设置
 */
public class PoiDemo7 {

	public static void main(String[] args) throws Exception {
		Workbook wb = new HSSFWorkbook(); // 新建Workbook接口
		Sheet sheet1 = wb.createSheet(); // 创建一个sheet 
		
		DataFormat dataFormat = wb.createDataFormat();
		CellStyle style;
		Row row;
		Cell cell;
		short rowNum = 0;
		short colNum = 0;
		
		row = sheet1.createRow(rowNum++);
		cell = row.createCell(colNum++);
		cell.setCellValue(12344.21);
		style = wb.createCellStyle();
		style.setDataFormat(dataFormat.getFormat("0.0")); // 设置数据格式 保留一位小数
		cell.setCellStyle(style);
		
		row = sheet1.createRow(rowNum++);
		cell = row.createCell(colNum++);
		cell.setCellValue(12344.21);
		style = wb.createCellStyle();
		style.setDataFormat(dataFormat.getFormat("#,##0.000")); // 设置数据格式 保留三位小数
		cell.setCellStyle(style);
		
		FileOutputStream fos = new FileOutputStream(PoiDemo7.class.getSimpleName() + ".xls"); // 创建输出流
		wb.write(fos);
		wb.close();
	}
	
}
