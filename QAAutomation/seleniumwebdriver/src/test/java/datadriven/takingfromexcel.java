package datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*; // For Sheet, Row, Cell, Workbook, etc.
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class takingfromexcel {

    // 1. Get Row Count
    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        FileInputStream fis = new FileInputStream(xlFile);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(xlSheet);
        int rowCount = sheet.getLastRowNum();
        wb.close();
        fis.close();
        return rowCount;
    }

    // 2. Get Cell Count
    public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException {
        FileInputStream fis = new FileInputStream(xlFile);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(xlSheet);
        Row row = sheet.getRow(rowNum);
        int cellCount = (row != null) ? row.getLastCellNum() : 0;
        wb.close();
        fis.close();
        return cellCount;
    }

    // 3. Get Cell Data
    public static String getCellData(String xlFile, String xlSheet, int rowNum, int cellNum) throws IOException {
        FileInputStream fis = new FileInputStream(xlFile);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(xlSheet);
        Row row = sheet.getRow(rowNum);
        Cell cell = (row != null) ? row.getCell(cellNum) : null;
        DataFormatter formatter = new DataFormatter();
        String data = (cell != null) ? formatter.formatCellValue(cell) : "";
        wb.close();
        fis.close();
        return data;
    }

    // 4. Set Cell Data
    public static void setCellData(String xlFile, String xlSheet, int rowNum, int cellNum, String data) throws IOException {
        FileInputStream fis = new FileInputStream(xlFile);
        Workbook wb = new XSSFWorkbook(fis);
        fis.close();

        Sheet sheet = wb.getSheet(xlSheet);
        if (sheet == null) sheet = wb.createSheet(xlSheet);

        Row row = sheet.getRow(rowNum);
        if (row == null) row = sheet.createRow(rowNum);

        Cell cell = row.getCell(cellNum);
        if (cell == null) cell = row.createCell(cellNum);

        cell.setCellValue(data);

        FileOutputStream fos = new FileOutputStream(xlFile);
        wb.write(fos);
        wb.close();
        fos.close();
    }
}
