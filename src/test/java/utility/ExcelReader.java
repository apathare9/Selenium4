package utility;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static String path;
    public static File file;
    public static FileInputStream fis;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public String sheetName = null;

    public static void readValuesFromExcel() {

        try {
            path = System.getProperty("user.dir") + "/Templates/Student_Data.xlsx";
            file = new File(path);
            fis = new FileInputStream(file);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Data");
            row = sheet.getRow(0);
            cell = row.getCell(2);
            String address = cell.getStringCellValue();

            System.out.println("Value is " + address);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static int getTotalRowFromExcel(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1) {
            return 0;
        } else {
            sheet = workbook.getSheetAt(index);
            int number = sheet.getLastRowNum() + 1;
            return number;
        }
    }

    public static int getTotalColumnsFromExcel(String sheetname) {
        int index = workbook.getSheetIndex(sheetname);
        if (index == -1) {
            return 0;
        } else {
            sheet = workbook.getSheetAt(index);
            XSSFRow row = sheet.getRow(0);
            int cellCount = row.getLastCellNum();
            return cellCount;
        }
    }

//    public static String getCellDataFromExcel(String sheetName, String columnName, int rowNumber) {
//        try {
//            if (rowNumber <= 0)
//                return "";
//
//            int index = workbook.getSheetIndex(sheetName);
//            int column_number = -1;
//            if (index == -1)
//                return "";
//
//            sheet = workbook.getSheetAt(index);
//            row = sheet.getRow(0);
//            for (int i=0; i<row.getLastCellNum(); i++) {
//                if (row.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
//                    column_number = i;
//                }
//            }
//
//            if (column_number == -1) {
//                return "";
//            }
//
//            sheet = workbook.getSheetAt(index);
//            row = sheet.getRow(rowNumber - 1);
//            if (row == null)
//                return "";
//            cell = row.getCell(column_number);
//
//            if (cell == null)
//                return "";
//
//            if (cell.getCellType().name().equals("STRING"))
//                return cell.getStringCellValue();
//
//            else if ((cell.getCellType().name().equals("NUMERIC")) || (cell.getCellType().name().equals("STRING"))) {
//                String cellText = String.valueOf(cell.getNumericCellValue());
//                if (XSSFData)
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static String getCellDataFromExcel(String sheetName, String columnName, int rowNumber) throws IOException {
        try {
            if (rowNumber <= 0)
                return "";

            // Create a new workbook
            String path = System.getProperty("user.dir") + "/Templates/Student_Data.xlsx";
            FileInputStream fis = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(fis);

            // Get the sheet
            Sheet sheet = workbook.getSheet(sheetName);

            // Find the column index
            int columnIndex = -1;
            for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
                if (sheet.getRow(0).getCell(i).getStringCellValue().trim().equalsIgnoreCase(columnName.trim())) {
                    columnIndex = i;
                    break;
                }
            }

            // Check if column found
            if (columnIndex == -1) {
                return "";
            }

            // Get the row
            Row row = sheet.getRow(rowNumber - 1);

            // Return the cell value
            Cell cell = row.getCell(columnIndex);
            if (cell == null) {
                return "";
            }

            return cell.getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }



}
