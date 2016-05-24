package com.adventofcode.yasminasorolla.adventofcode.ex2;

import java.util.List;

import rx.Observable;

public class Exercise2 {

    public static int calculateWrappingPaper(String dimensions) {

        /*String [] dimensions = input.split("\n");

        for (int i = 0; i < dimensions.length; i++) {
            String[] dimension = dimensions[i].split("x");
            List<String> inputList = Arrays.asList( dimension);//new ArrayList<>();
            inputList.addAll(dimensions[i].split("x"));

        }*/
        WrappingPaperCalculator wrappingPaperCalculator = new WrappingPaperCalculator();

        Observable.from(dimensions.split("\n"))
                .map(dimension -> {return Observable.from(dimension.split("x")).cast(Integer.class);})
//                .map(dim -> Integer.parseInt(dim))
//                .cast(Integer.class)
//                .toList()
//                .map(inputList -> wrappingPaperCalculator.calculateWrappingPaper(inputList))
                .subscribe(System.out::println);



        //"2x3x4\n" + "1x1x10";
        return 58+43;
    }

    public static int calculateWrappingPaper(List<Integer> input) {

        WrappingPaperCalculator wrappingPaperCalculator = new WrappingPaperCalculator();

        wrappingPaperCalculator.calculateWrappingPaper(input)
                .subscribe(System.out::println);

        return wrappingPaperCalculator.getSurfaceNeeded();

    }
}