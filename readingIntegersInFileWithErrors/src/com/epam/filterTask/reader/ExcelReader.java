package com.epam.filterTask.reader;

import com.epam.filterTask.exeption.ReadExeption;
import com.epam.filterTask.validation.Validator;
import com.epam.filterTask.validation.impl.ValidatorImpl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ExcelReader {

    public List<String> readDataExcel(String path) throws ReadExeption {
        File file = new File(path);
        Validator fileValidator = new ValidatorImpl();  //предполагается, что высокая вероятность некорректности файла
        boolean resultValidator;
        resultValidator = fileValidator.checkFile(file);
        if (!resultValidator) {
            throw new ReadExeption("File is not exist or empty - " + path);
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            Workbook wb = new HSSFWorkbook(fis);
            List<String> strings = new ArrayList<>();
            String str;
            for (Row row : wb.getSheetAt(0)) {
                str = "";
                for (Cell cell : row) {
                    str += " " + getCellText(cell);
                }
                if (!str.isEmpty()) {
                    strings.add(str);
                }
            }
            return strings;
        } catch (IOException e) {
            throw new ReadExeption(e);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                System.err.println("Ошибка закрытия - " + e);
            }

        }
    }


    public static String getCellText(Cell cell) {
        String result = "";
        switch (cell.getCellType()) {
            case STRING:
                result = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                if(DateUtil.isCellDateFormatted(cell)) {
                    result = cell.getDateCellValue().toString();
                } else {
                    result =Double.toString(cell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                result = Boolean.toString(cell.getBooleanCellValue());
                break;
            case FORMULA:
                result = cell.getCellFormula();
                break;
            default:
                break;
        }
        return result;
    }
}
