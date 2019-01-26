package com.epam.filterTask.validation.impl;

import com.epam.filterTask.validation.Validator;

import java.io.File;

public class ValidatorImpl implements Validator {
    @Override
    public boolean checkFile(File file){
        if(file == null || !file.exists() || file.isDirectory() || file.length() == 0 ) {
            return false;
        }
        return true;
    }
}