package com.example.testbatchprocessing;

import com.example.testbatchprocessing.config.ExcelItemReader;
import com.example.testbatchprocessing.pojo.People;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ExcelGeneralNumberFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.apache.poi.ss.usermodel.CellType.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestbatchprocessingApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void pojo2ExcelTest() {
        ClassPathResource classPathResource = new ClassPathResource("/data/init/springbatchtest1.xlsx");
        // File file = ResourceUtils.getFile("classpath:/data/init/springbatchtest1.xlsx")
        try {
            FileInputStream fis = (FileInputStream) classPathResource.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LinkedHashMap<String, String> alias = new LinkedHashMap<>();
        alias.put("姓名", "name");
        alias.put("年龄", "age");
        alias.put("学校", "school");
        alias.put("财富", "wealth");

        // List<People> peopleList = Excel
    }

    @Test
    public void excelToCsv() throws IOException {
        BufferedWriter bw = null;
        ClassPathResource classPathResource = new ClassPathResource("/data/init/springbatchtest2.xlsx");
        // ClassPathResource classPathReadResource = new ClassPathResource("/data/init/springbatchtest2.csv");
        File file = new File(ResourceUtils.getURL("classpath:data/init").getPath(), "springbatchtest2.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        XSSFWorkbook wb = new XSSFWorkbook(classPathResource.getInputStream());
        System.out.println("Datadump:\n");
        for (int k = 0; k < wb.getNumberOfSheets(); k++) {
            XSSFSheet sheet = wb.getSheetAt(k);
            int rows = sheet.getPhysicalNumberOfRows();
            // Iterator<Row> d = sheet.rowIterator();
            System.out.println(MessageFormat.format("excel 第{0}页，共{1}行", k, rows));
            for (int r = 0; r < rows; r++) {
                XSSFRow row = sheet.getRow(r);
                if (row == null) {
                    bw.newLine();
                    continue;
                }
                int cells = row.getPhysicalNumberOfCells();
                System.out.println(MessageFormat.format("第{0}行有{1}列", r, cells));
                List<String> values = new ArrayList<>();
                for (int c = 0; c < cells; c++) {
                    XSSFCell cell = row.getCell(c);
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            // value = String.valueOf(cell.getNumericCellValue());
                            values.add(String.valueOf(cell.getNumericCellValue()));
                            // bw.write(value);
                            break;
                        case STRING:
                            values.add(String.valueOf(cell.getStringCellValue()));
                            // bw.write(value);
                            break;
                        default:
                    }
                }
                String message = values.stream().collect(joining(","));
                bw.write(message);
                System.out.print(message);
                // bw.write("\r\n");
                bw.newLine();
                System.out.println();
            }
        }
        bw.close();
        wb.close();
    }
}
