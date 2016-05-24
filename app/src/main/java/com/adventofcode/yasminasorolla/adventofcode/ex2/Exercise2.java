package com.adventofcode.yasminasorolla.adventofcode.ex2;

import java.util.List;

public class Exercise2 {

    public static int calculateWrappingPaper(List<Integer> input) {

        WrappingPaperCalculator wrappingPaperCalculator = new WrappingPaperCalculator();

        wrappingPaperCalculator.calculateWrappingPaper(input)
                .subscribe(System.out::println);

        return wrappingPaperCalculator.getSurfaceNeeded();

    }
}