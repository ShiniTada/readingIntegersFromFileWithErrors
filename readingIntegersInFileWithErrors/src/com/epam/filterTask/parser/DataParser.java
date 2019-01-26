package com.epam.filterTask.parser;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class DataParser {

    public static final String SEPARATOR =  "(\\.0)|\\D+";
    public static final String NUMBERS =  "\\d+";

    public List<Integer> parser(List<String> strings){
        List<Integer> integers = strings.stream()
                .parallel()
                .flatMap(Pattern.compile(SEPARATOR)::splitAsStream)
                .filter(Pattern.compile(NUMBERS).asPredicate())
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return integers;
    }
}
