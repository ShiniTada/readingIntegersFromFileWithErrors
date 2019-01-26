package com.epam.filterTask.exeption;

public class ReadExeption extends Exception {

    public ReadExeption() {}

    public ReadExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ReadExeption(Throwable cause) {
        super(cause);
    }

    public ReadExeption(String message) { super(message); }
}
