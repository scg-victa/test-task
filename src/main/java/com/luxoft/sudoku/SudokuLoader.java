package com.luxoft.sudoku;

import java.util.List;

public interface SudokuLoader {
    int[][] load(String... args) throws SudokuException;
}
