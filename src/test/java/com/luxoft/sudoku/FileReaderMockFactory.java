package com.luxoft.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderMockFactory {

    public static final String CORRECT_LINE = "1,,3,,,,7,,9";
    public static final String INCORRECT_LINE_1 = "1,,3,21,,,7,,9";
    public static final String INCORRECT_LINE_2 = "1,,3,,7,,9";
    public static final String INCORRECT_LINE_3 = "1,,3,b,,,7,,9";


    public static SudokuFileLoader.FileReader getReaderIOException() {
        return new SudokuFileLoader.FileReader() {
            public List<String> readInput(String... args) throws SudokuException {
                throw new SudokuException(SudokuException.ERROR_IN_LOADING,
                        "Could not load file '" + args[0] + "'. Check path and file name.");
            }
        };
    }

    // returns 6 lines instead 9
    public static SudokuFileLoader.FileReader getReaderIncorrectLineAmount() {
        return new SudokuFileLoader.FileReader() {
            public List<String> readInput(String... args) throws SudokuException {
                return new ArrayList<>(Arrays.asList(
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE,
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE));
            }
        };
    }

    public static SudokuFileLoader.FileReader getReaderIncorrectElementsAmount() {
        return new SudokuFileLoader.FileReader() {
            public List<String> readInput(String... args) throws SudokuException {
                return new ArrayList<>(Arrays.asList(
                        CORRECT_LINE, INCORRECT_LINE_2, CORRECT_LINE,
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE,
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE));
            }
        };
    }

    public static SudokuFileLoader.FileReader getReaderIncorrectNumber() {
        return new SudokuFileLoader.FileReader() {
            public List<String> readInput(String... args) throws SudokuException {
                return new ArrayList<>(Arrays.asList(
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE,
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE,
                        INCORRECT_LINE_1, CORRECT_LINE, CORRECT_LINE));
            }
        };
    }

    public static SudokuFileLoader.FileReader getReaderIncorrectNumberAlphabet() {
        return new SudokuFileLoader.FileReader() {
            public List<String> readInput(String... args) throws SudokuException {
                return new ArrayList<>(Arrays.asList(
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE,
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE,
                        CORRECT_LINE, CORRECT_LINE, INCORRECT_LINE_3));
            }
        };
    }

    public static SudokuFileLoader.FileReader getReaderCorrectData() {
        return new SudokuFileLoader.FileReader() {
            public List<String> readInput(String... args) throws SudokuException {
                return new ArrayList<>(Arrays.asList(
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE,
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE,
                        CORRECT_LINE, CORRECT_LINE, CORRECT_LINE));
            }
        };
    }


}
