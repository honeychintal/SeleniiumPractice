package com.banking.testCases;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    String file = System.getProperty("user.dir") + "/Resources/DDT_excel.xlsx";
    @Test
    public void readExcelwithHashmap() throws IOException {
        Map<String, String> map = new HashMap<>();
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rowscount = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowscount; i++) {
            String key = sheet.getRow(i).getCell(0).toString();
            String value = sheet.getRow(i).getCell(1).toString();
            map.put(key, value);
        }
        //accessing all keys and values in "Hashmap"
        for (Map.Entry<String,String> m:map.entrySet()){
            System.out.println(m.getKey()+"|"+m.getValue());
        }
        //accessing value for any specific key in "Hashmap"
        System.out.println(map.get("Admin5"));
    }
}

