package com.luxoft.sudoku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// correctness:
// 9 lines with 9 numbers divided by ',' or empty
// 1 <= number <= 9
// 1,2,,,3,,,,9 - correct
// a,12,3x - incorrect

@Component
public class SudokuFileLoader implements SudokuLoader {
    private InputValidator inputValidator;
    private FileReader reader;

    @Autowired
    public SudokuFileLoader(FileReader reader, InputValidator inputValidator) {
        this.reader = reader;
        this.inputValidator = inputValidator;
    }


    @Component
    public static class FileReader {
        public List<String> readInput(String... args) throws SudokuException {
            if (args == null || args.length == 0) {
                throw new SudokuException(SudokuException.INCORRECT_ARGUMENT,
                        "There are not argument with file name. Check application command line argument.");
            }

            List<String> inputLines = null;
            Path path = Paths.get(args[0]);
            try {
                inputLines = Files.lines(path).collect(Collectors.toList());
            } catch(IOException e) {
                throw new SudokuException(SudokuException.ERROR_IN_LOADING,
                        "Could not load file '" + args[0] + "'. Check path and file name.");
            }
            return inputLines;
        }
    }



    @Override
    public int[][] load(String... args) throws SudokuException {
        List<String> lines = reader.readInput(args);
        inputValidator.validateNullAndLength(lines);

        int[][] sudoku = new int[9][];
        for(int i = 0; i < 9; i++) {
            try {
                sudoku[i] = Arrays.stream(lines.get(i).split(",", -1))
                        .map(String::trim)
                        .mapToInt(x -> {
                            if (x.length() == 0) {
                                return 0;
                            }
                            inputValidator.validateIsDigit(x);
                            return x.length() > 0 ? Integer.parseInt(x) : '0';
                        })
                        .toArray();
            } catch(SudokuRuntimeException ex) {
                throw new SudokuException(ex.getErrorCode(), ex.getMessage());
            }
            inputValidator.validateNullAndLength(sudoku[i]);
        }

        return sudoku;
    }
}
