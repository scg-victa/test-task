package com.luxoft.sudoku;

public class SudokuRuntimeException extends RuntimeException {

    private int code;

    public SudokuRuntimeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getErrorCode() {
        return code;
    };
}
