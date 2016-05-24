package com.adventofcode.yasminasorolla.adventofcode.ex1;

public class Exercise1 {

    public static int calculateFloor(String input){

        Santa santa = new Santa();

        santa.calculateFinalFloor(input)
                .subscribe(System.out::println);

        return santa.getFinalFloor();

    }

}