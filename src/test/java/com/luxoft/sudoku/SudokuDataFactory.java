package com.luxoft.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuDataFactory {

    public static int[][] getIncorrectRow() {
        return new int[][] {
                {0,0,4,0,6,0,7,0,1},
                {0,2,0,4,0,3,0,8,0},
                {8,0,0,0,0,0,0,0,4},
                {9,0,1,8,4,9,6,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,3,2,5,7,9,0,0},
                {4,0,0,0,0,0,0,0,7},
                {0,8,0,6,0,4,0,5,0},
                {5,0,6,0,8,0,2,0,3}};
    }

    public static int[][] getIncorrectColumn() {
        return new int[][] {
                {9,0,4,0,6,0,7,0,1},
                {0,2,0,4,0,3,0,8,0},
                {8,0,0,0,0,0,0,0,4},
                {4,0,1,8,0,9,6,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,3,2,5,7,9,0,0},
                {4,0,0,0,0,0,0,0,7},
                {0,8,0,6,0,4,0,5,0},
                {5,0,6,0,8,0,2,0,3}};
    }

    public static int[][] getIncorrectBlock() {
        return new int[][] {
                {9,0,4,0,6,0,7,0,1},
                {0,2,0,4,0,3,0,8,0},
                {8,0,0,0,0,0,0,0,4},
                {0,0,1,8,4,6,9,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,3,2,5,7,9,0,0},
                {4,0,0,0,0,0,0,0,7},
                {0,8,0,6,0,4,0,5,0},
                {5,0,6,0,8,0,2,0,3}};
    }

    public static int[][] getCorrect() {
        return new int[][] {
                {9,0,4,0,6,0,7,0,1},
                {0,2,0,4,0,3,0,8,0},
                {8,0,0,0,0,0,0,0,4},
                {0,0,1,8,4,9,6,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,3,2,5,7,9,0,0},
                {4,0,0,0,0,0,0,0,7},
                {0,8,0,6,0,4,0,5,0},
                {5,0,6,0,8,0,2,0,3}};
    }


}
