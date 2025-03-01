package org.example.readcsv;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.sendmail.SendMail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

        String filePath = "/Users/panda/Downloads/Tp.xlsx"; // Change this path

    public void readFile(){
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Reading the first sheet

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row

                String name = row.getCell(0).getStringCellValue();
                String companyName = row.getCell(1).getStringCellValue();
                String emailId = row.getCell(2).getStringCellValue();

                SendMail sm = new SendMail(name, companyName,emailId);
                sm.sendAttach();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
