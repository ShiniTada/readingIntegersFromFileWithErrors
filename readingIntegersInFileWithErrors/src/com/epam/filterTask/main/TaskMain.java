package com.epam.filterTask.main;

import com.epam.filterTask.action.ArrayAction;
import com.epam.filterTask.exeption.ReadExeption;
import com.epam.filterTask.parser.DataParser;
import com.epam.filterTask.reader.ExcelReader;
import com.epam.filterTask.reader.TxtReader;

import java.util.List;

public class TaskMain  {

    public static void main(String[] args) throws ReadExeption {
        TaskMain objForMain = new TaskMain();

        System.out.println("\n\nСЧИТЫВАНИЕ С TXT");
        TxtReader readTxt = new TxtReader();
        List<String> stringsTxt = readTxt.readDataTxt("data\\integers.txt");
        objForMain.CallParsingAndShowResults(stringsTxt);

        System.out.println("\n\nСЧИТЫВАНИЕ С EXCEL");
        ExcelReader readEx = new ExcelReader();
        List<String> stringsEx = readEx.readDataExcel("data\\integersExcel.xls");
        objForMain.CallParsingAndShowResults(stringsEx);
    }

    public void CallParsingAndShowResults(List<String> strings) {
        DataParser parse = new DataParser();
        List<Integer> integers = parse.parser(strings);
        System.out.println(integers);
        ArrayAction work = new ArrayAction();
        System.out.println("sum - " + work.sum(integers));
        System.out.println("max - " + work.max(integers));
        System.out.println("min - " + work.min(integers));
    }


}