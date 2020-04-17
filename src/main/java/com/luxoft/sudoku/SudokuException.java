package com.luxoft.sudoku;

public class SudokuException extends Exception {

    public static final int INVALID_SUDOKU = 1;
    public static final int INCORRECT_ARGUMENT = 2;
    public static final int ERROR_IN_LOADING = 3;
    public static final int INCORRECT_INPUT_FILE = 4;


    private int code;

    public SudokuException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getErrorCode() {
        return code;
    };

}
