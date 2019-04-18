package sample;

import com.ibm.icu.text.RuleBasedNumberFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.Locale;

public class ExcelLib {


    public void createXLSX (MyModel model) {
        String path = "/example.xlsx";
        InputStream inputStream = null;
        XSSFWorkbook workbook = null;
        try {
            inputStream = new FileInputStream(this.getClass().getResource(path).getPath());
            workbook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet sheet = workbook.getSheetAt(0);

        // заполнение ОКПО
        Row row = sheet.getRow(5);
        row.getCell(47).setCellValue(model.OKPO);

        // заполнение организации
        row = sheet.getRow(5);
        row.getCell(1).setCellValue(model.organization);

        // заполнение ОКДП
        row = sheet.getRow(8);
        row.getCell(47).setCellValue(model.OKDP);

        // заполнение подразделения
        row = sheet.getRow(7);
        row.getCell(1).setCellValue(model.unit);

        // номер акта
        row = sheet.getRow(14);
        row.getCell(28).setCellValue(model.actNumber);

        // Дата составления
        row = sheet.getRow(25);
        row.getCell(25).setCellValue(model.pole11);

        row = sheet.getRow(27);
        row.getCell(25).setCellValue(model.pole12);

        row = sheet.getRow(28);
        row.getCell(25).setCellValue(model.pole13);

        row = sheet.getRow(29);
        row.getCell(25).setCellValue(model.pole14);

        row = sheet.getRow(30);
        row.getCell(25).setCellValue(model.pole15);

        row = sheet.getRow(33);
        row.getCell(25).setCellValue(model.pole16);

        row = sheet.getRow(36);
        row.getCell(25).setCellValue(model.pole17);

        row = sheet.getRow(25);
        row.getCell(34).setCellValue(model.pole21);

        row = sheet.getRow(27);
        row.getCell(34).setCellValue(model.pole22);

        row = sheet.getRow(28);
        row.getCell(34).setCellValue(model.pole23);

        row = sheet.getRow(29);
        row.getCell(34).setCellValue(model.pole24);

        row = sheet.getRow(30);
        row.getCell(34).setCellValue(model.pole25);

        row = sheet.getRow(33);
        row.getCell(34).setCellValue(model.pole26);

        row = sheet.getRow(36);
        row.getCell(34).setCellValue(model.pole27);

        row = sheet.getRow(14);
        row.getCell(34).setCellValue(model.dataCreator);

        int finalRub = (int) Double.parseDouble(model.finalRes);
        RuleBasedNumberFormat nf = new RuleBasedNumberFormat(Locale.forLanguageTag("ru"),
                RuleBasedNumberFormat.SPELLOUT);
        int finalKop = (int) (Double.parseDouble(model.finalRes) * 100) % 100 ;
        row = sheet.getRow(53);
        row.getCell(1).setCellValue(nf.format(finalRub) + " руб  " + nf.format(finalKop) + " коп");





        try (FileOutputStream out = new FileOutputStream("/home/dmitry/Documents/excel1.xlsx")) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
