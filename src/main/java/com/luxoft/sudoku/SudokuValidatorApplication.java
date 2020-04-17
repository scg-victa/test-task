package com.luxoft.sudoku;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SudokuValidatorApplication implements CommandLineRunner {

    public static final int VALID = 0;
    public static final String VALID_MSG = "The Sudoku is valid";

    @Autowired
    private SudokuCorrectnessValidator validator;
    @Autowired
    private SudokuLoader loader;

    public static void main(String... args) {
        SpringApplication.run(SudokuValidatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            int[][] input = loader.load(args);
            validator.validate(input);
            System.out.println(VALID + " : " + VALID_MSG);
        } catch(SudokuException ex) {
            System.out.println(ex.getErrorCode() + " : " + ex.getMessage());
        }

    }
}
