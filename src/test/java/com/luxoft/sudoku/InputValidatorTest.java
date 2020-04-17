package com.luxoft.sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidatorTest {

    private static final List<String> NULL_LIST = null;
    private static final List<String> INCORRECT_LIST = new ArrayList<>();
    private static final List<String> CORRECT_LIST = new ArrayList<>();

    private static final String LINE = "1,,,6,,9,2,,";

    private static final int[] CORRECT_LINE = {1,0,3,0,0,0,7,0,9};
    private static final int[] INCORRECT_LINE = {1,0,3,0,7,0,9};
    private static final int[] NULL_LINE = null;

    private static final String INCORRECT_NUMBER = "35";
    private static final String INCORRECT_NO_NUMBER = "c";
    private static final String CORRECT_NUMBER = "3";

    private InputValidator inputValidator = new InputValidator();

    @Test
    public void testValidateNullAndLengthListCorrect() throws SudokuException {
        CORRECT_LIST.clear();
        for (int i = 0; i < 9; i++) {
            CORRECT_LIST.add(LINE);
        }

        inputValidator.validateNullAndLength(CORRECT_LIST);
    }

    @Test
    public void testValidateNullAndLengthListInCorrect() {
        INCORRECT_LIST.clear();
        INCORRECT_LIST.addAll(Arrays.asList(LINE, LINE, LINE));

        SudokuException ex = Assertions.assertThrows(SudokuException.class, () -> {
            inputValidator.validateNullAndLength(INCORRECT_LIST);
        });
        Assertions.assertEquals(SudokuException.INCORRECT_INPUT_FILE, ex.getErrorCode());
    }

    @Test
    public void testValidateNullListInCorrect() {
        SudokuException ex = Assertions.assertThrows(SudokuException.class, () -> {
            inputValidator.validateNullAndLength(NULL_LIST);
        });
        Assertions.assertEquals(SudokuException.INCORRECT_INPUT_FILE, ex.getErrorCode());
    }

    @Test
    public void testValidateNullAndLengthArrayCorrect() throws SudokuException {
        inputValidator.validateNullAndLength(CORRECT_LINE);
    }

    @Test
    public void testValidateNullAndLengthArrayInCorrect() {
        SudokuException ex = Assertions.assertThrows(SudokuException.class, () -> {
            inputValidator.validateNullAndLength(INCORRECT_LINE);
        });
        Assertions.assertEquals(SudokuException.INCORRECT_INPUT_FILE, ex.getErrorCode());
    }

    @Test
    public void testValidateNullArrayInCorrect() {
        SudokuException ex = Assertions.assertThrows(SudokuException.class, () -> {
            inputValidator.validateNullAndLength(NULL_LINE);
        });
        Assertions.assertEquals(SudokuException.INCORRECT_INPUT_FILE, ex.getErrorCode());
    }

    @Test
    public void testValidateIsDigitCorrect() throws SudokuException {
        inputValidator.validateIsDigit(CORRECT_NUMBER);
    }

    @Test
    public void testValidateIsDigitNumberInCorrect() {
        SudokuRuntimeException ex = Assertions.assertThrows(SudokuRuntimeException.class, () -> {
            inputValidator.validateIsDigit(INCORRECT_NUMBER);
        });
        Assertions.assertEquals(SudokuException.INCORRECT_INPUT_FILE, ex.getErrorCode());
    }

    @Test
    public void testValidateIsDigitNoNumberInCorrect() {
        SudokuRuntimeException ex = Assertions.assertThrows(SudokuRuntimeException.class, () -> {
            inputValidator.validateIsDigit(INCORRECT_NO_NUMBER);
        });
        Assertions.assertEquals(SudokuException.INCORRECT_INPUT_FILE, ex.getErrorCode());
    }

}
