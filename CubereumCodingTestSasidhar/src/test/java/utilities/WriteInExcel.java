package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteInExcel {

    public static void writingToExcel(String product, String price) throws IOException {

        Workbook workbook = new XSSFWorkbook();

        //create the sheet from the excel file
        Sheet sheet = workbook.createSheet("OutputData");
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"Name of the Product", "Price"});
        data.put("2", new Object[]{product, price});

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            //Write the workbook in file system
            String currentDir = System.getProperty("user.dir");
            FileOutputStream out = new FileOutputStream(new File(currentDir + "\\src\\test\\resources\\TestData\\OutputDataFile.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


