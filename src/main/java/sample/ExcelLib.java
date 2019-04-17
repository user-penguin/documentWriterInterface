package sample;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ExcelLib {


    public void createXLSX (MyModel mokel) {
        String path = "example.xlsx";
        InputStream inputStream = null;
        XSSFWorkbook workbook = null;
        try {
            inputStream = new FileInputStream(this.getClass().getResource(path).getPath());
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(14);
        row.getCell(29).setCellValue("23");
        row.getCell(35).setCellValue("23");
        try (FileOutputStream out = new FileOutputStream("/home/dmitry/Documents/excel1.xlsx")) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
