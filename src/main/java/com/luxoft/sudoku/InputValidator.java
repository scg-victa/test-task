package com.luxoft.sudoku;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class InputValidator {

    private final Pattern pattern = Pattern.compile("\\d");

    public void validateNullAndLength(List<String> list) throws SudokuException {
        if (list == null || list.size() != 9) {
            throw new SudokuException(SudokuException.INCORRECT_INPUT_FILE,
                    "Rows amount does not equal 9. Check input.");
        }
    }

    public void validateNullAndLength(int[] array) throws SudokuException {
        if (array == null || array.length != 9) {
            throw new SudokuException(SudokuException.INCORRECT_INPUT_FILE,
                    "Some columns amount does not equal 9. Check input.");
        }
    }

    public void validateIsDigit(String token){
        if (!pattern.matcher(token).matches()) {
            throw new SudokuRuntimeException(SudokuException.INCORRECT_INPUT_FILE,
                    "Sudoku element is not number or not digit between 1 and 9. Check input.");
        }
    }

}
