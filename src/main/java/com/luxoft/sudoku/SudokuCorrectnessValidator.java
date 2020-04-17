package com.luxoft.sudoku;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SudokuCorrectnessValidator {
    private SudokuException invalid = new SudokuException(SudokuException.INVALID_SUDOKU,
            "The Sudoku is invalid");

    public void validate(int[][] sudoku) throws SudokuException {
        for(int i = 0; i < 9; i++) {
            int[] blockRow = getRowValues(sudoku, i);
            checkValues(blockRow);

            int[] blockColumn = getColumnValues(sudoku, i);
            checkValues(blockColumn);

            int[] blockBlock = getBlockValues(sudoku, i);
            checkValues(blockBlock);
        }
    }


    private void checkValues(int[] input) throws SudokuException {
        Set<Integer> set = new HashSet<>();

        for(Integer i : input) {
            if (i == 0) continue;

            if (set.contains(i)) {
                throw invalid;
            }
            set.add(i);
        }
    }

    private int[] getRowValues(int[][] input, int index) {
        return input[index];
    }

    private int[] getBlockValues(int[][] input, int index) {
        int ver = index % 3;
        int hor = index / 3;

        int[] result = new int[9];
        for (int i = 0, j = 0; i < 9; i++) {
            result[i] = input[j + hor * 3][i % 3 + ver * 3];
            if ((i % 3) == 2) j++;
        }
        return result;
    }

    private int[] getColumnValues(int[][] input, int index) {
        int[] result = new int[9];
        for (int i = 0; i < 9; i++) {
            result[i] = input[i][index];
        }
        return result;
    }
}
