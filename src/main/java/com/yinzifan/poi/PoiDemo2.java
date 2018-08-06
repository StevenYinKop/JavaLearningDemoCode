package com.yinzifan.poi;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class PoiDemo2 {

	public static void main(String[] args) throws Exception {
		Workbook wb = new HSSFWorkbook(); // 新建Workbook接口
		Sheet sheet1 = wb.createSheet(); // 创建一个sheet 
		Row row = sheet1.createRow(0); // 创建第0行
		Cell cell = row.createCell(0); // 创建一个单元格
		cell.setCellValue("abcd");
		wb.createSheet("custom name sheet"); // 创建一个sheet(自定义sheet名称)
		FileOutputStream fos = new FileOutputStream(System.currentTimeMillis() + PoiDemo2.class.getSimpleName() + ".xls"); // 创建输出流
		wb.write(fos);
		wb.close();
	}
	
}
