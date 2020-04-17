package com.luxoft.sudoku;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SudokuFileLoaderTest {

    private InputValidator validator = new InputValidator();
    private SudokuLoader loader;

    @Test
    public void testLoadFileNoArgument() {
        loader = new SudokuFileLoader(new SudokuFileLoader.FileReader(), validator);
        SudokuException ex = Assertions.assertThrows(SudokuException.class, () -> {
            loader.load(new String[] {});
        });
        Assertions.assertEquals(SudokuException.INCORRECT_ARGUMENT, ex.getErrorCode());
    }

    @Test
    public void testLoadFileIOException() {
        loader = new SudokuFileLoader(FileReaderMockFactory.getReaderIOException(), validator);
        SudokuException ex = Assertions.assertThrows(SudokuException.class, () -> {
            loader.load(new String[] {"test.txt"});
        });
        Assertions.assertEquals(SudokuException.ERROR_IN_LOADING, ex.getErrorCode());
    }

    @Test
    public void testLoadFileIncorrectData() {
        loader = new SudokuFileLoader(FileReaderMockFactory.getReaderIncorrectLineAmount(), validator);
        SudokuException ex = Assertions.assertThrows(SudokuException.class, () -> {
            loader.load(new String[] {"test.txt"});
        });
        Assertions.assertEquals(SudokuException.INCORRECT_INPUT_FILE, ex.getErrorCode());

        loader = new SudokuFileLoader(FileReaderMockFactory.getReaderIncorrectElementsAmount(), validator);
        ex = Assertions.assertThrows(SudokuException.class, () -> {
            loader.load(new String[] {"test.txt"});
        });
        Assertions.assertEquals(SudokuException.INCORRECT_INPUT_FILE, ex.getErrorCode());

        loader = new SudokuFileLoader(FileReaderMockFactory.getReaderIncorrectNumber(), validator);
        ex = Assertions.assertThrows(SudokuException.class, () -> {
            loader.load(new String[] {"test.txt"});
        });
        Assertions.assertEquals(SudokuException.INCORRECT_INPUT_FILE, ex.getErrorCode());

        loader = new SudokuFileLoader(FileReaderMockFactory.getReaderIncorrectNumberAlphabet(), validator);
        ex = Assertions.assertThrows(SudokuException.class, () -> {
            loader.load(new String[] {"test.txt"});
        });
        Assertions.assertEquals(SudokuException.INCORRECT_INPUT_FILE, ex.getErrorCode());
    }

    @Test
    public void testLoadFileCorrect() throws SudokuException{
        loader = new SudokuFileLoader(FileReaderMockFactory.getReaderCorrectData(), validator);
        int[][] sudoku = loader.load(new String[] {"test.txt"});
        Assertions.assertNotNull(sudoku);
        Assertions.assertEquals(9, sudoku.length);
        for (int i = 0; i < 9; i++) {
            Assertions.assertNotNull(sudoku[i]);
            Assertions.assertEquals(9, sudoku[i].length);
        }
    }

}
