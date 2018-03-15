package csv;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static csv.CSVReaderExample.CSVRead;
import static csv.JerseyRestBNM.BNM;

public class ApachePOITest {

    public static void main(String[] args) throws IOException {

        String[] columns = {"NumCode", "CharCode", "Nominal", "Name", "Value"};

        ArrayList<String> dateList = CSVRead();
        ArrayList<ArrayList<Valute>> valuteList = BNM();

        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();

        int index = 0;
        for (ArrayList<Valute> curVal : valuteList) {

            // Create a Sheet
            Sheet sheet = workbook.createSheet(dateList.get(index));
            // Create a Font for styling header cells
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setColor(IndexedColors.DARK_BLUE.getIndex());

            // Create a CellStyle with the font
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Create a Row
            Row headerRow = sheet.createRow(0);

            // Creating cells
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerCellStyle);
            }

            // Create Other rows and cells with valute data
            int rowNum = 1;

            for (Valute cursValute : curVal) {

                Row row = sheet.createRow(rowNum++);

                row.createCell(0)
                        .setCellValue(cursValute.getNumCode());

                row.createCell(1)
                        .setCellValue(cursValute.getCharCode());

                row.createCell(2)
                        .setCellValue(cursValute.getNominal());

                row.createCell(3)
                        .setCellValue(cursValute.getName());

                row.createCell(4)
                        .setCellValue(cursValute.getValue());

                // Resize all columns to fit the content size
                for (int i = 0; i < columns.length; i++) {
                    sheet.autoSizeColumn(i);
                }
            }

            index++;
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("currency_rates_from_BNM.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
}

