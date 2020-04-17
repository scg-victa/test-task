package com.luxoft.sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SudokuCorrectnessValidatorTest {

    private SudokuCorrectnessValidator validator = new SudokuCorrectnessValidator();

    @Test
    public void testValidateCorrect() throws SudokuException {
        int[][] sudoku = SudokuDataFactory.getCorrect();
        validator.validate(sudoku);
    }

    @Test
    public void testValidateIncorrectRow() throws SudokuException {
        int[][] sudoku = SudokuDataFactory.getIncorrectRow();
        SudokuException ex = Assertions.assertThrows(SudokuException.class, () -> {
            validator.validate(sudoku);
        });
        Assertions.assertEquals(SudokuException.INVALID_SUDOKU, ex.getErrorCode());
    }

    @Test
    public void testValidateIncorrectColumn() {
        int[][] sudoku = SudokuDataFactory.getIncorrectColumn();
        SudokuException ex = Assertions.assertThrows(SudokuException.class, () -> {
            validator.validate(sudoku);
        });
        Assertions.assertEquals(SudokuException.INVALID_SUDOKU, ex.getErrorCode());
    }

    @Test
    public void testValidateIncorrectBlock() {
        int[][] sudoku = SudokuDataFactory.getIncorrectBlock();
        SudokuException ex = Assertions.assertThrows(SudokuException.class, () -> {
            validator.validate(sudoku);
        });
        Assertions.assertEquals(SudokuException.INVALID_SUDOKU, ex.getErrorCode());
    }
}
