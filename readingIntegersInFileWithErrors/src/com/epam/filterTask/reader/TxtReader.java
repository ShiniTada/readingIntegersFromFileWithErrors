package com.epam.filterTask.reader;


import com.epam.filterTask.exeption.ReadExeption;
import com.epam.filterTask.validation.Validator;
import com.epam.filterTask.validation.impl.ValidatorImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public class TxtReader {

    public List<String> readDataTxt(String path) throws  ReadExeption{
        File file = new File(path);
        Validator fileValidator = new ValidatorImpl();  //предполагается, что высокая вероятность некорректности файла
        boolean resultValidator;
        resultValidator = fileValidator.checkFile(file);
        if(!resultValidator) {
            throw new ReadExeption("File is not exist or empty - " + path);
        }
        try {
            return Files.readAllLines(file.toPath());
        } catch(IOException e){
            throw new  ReadExeption(e);
        }
    }


}


