package com.Vtiger.genericmethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	
	public static void createExcel(String path, String sheetName) throws Exception {
		Workbook w = new XSSFWorkbook();
		Sheet sh = w.createSheet(sheetName);
		sh.createRow(0).createCell(0).setCellValue("Test case Name");
		sh.getRow(0).createCell(1).setCellValue("Status");
		FileOutputStream fileOut = new FileOutputStream(path);
		w.write(fileOut);
		fileOut.close();
		w.close();
	}

	public static void setData(String Name, String status, int row, int col, String sheet, String path)
			throws Throwable {
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			sh.createRow(row).createCell(col).setCellValue(Name);
			col++;
			sh.getRow(row).createCell(col).setCellValue(status);
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String getData(String path, String sheet, int row, int col) {
		String value = "";
		Workbook w;
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			w = WorkbookFactory.create(fis);
			value = w.getSheet(sheet).getRow(row).getCell(col).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
