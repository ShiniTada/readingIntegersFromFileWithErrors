package com.epam.filterTask.action;

import java.util.Collections;
import java.util.List;

public class ArrayAction {

    public int min(List<Integer> integers) {
        int minNumber = Collections.min(integers);
        return minNumber;
    }

    public int max(List<Integer> integers) {
        int maxNumber = Collections.max(integers);
        return maxNumber;
    }

    public int sum(List<Integer> integers) {
        int sumIntegers = 0;
        for (int element : integers) {
            sumIntegers += element;
        }
        return sumIntegers;
    }
}

