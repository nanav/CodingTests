package com.adventofcode.yasminasorolla.adventofcode.ex3;

import com.adventofcode.yasminasorolla.adventofcode.utils.Pair;

import java.util.HashSet;

/**
 * Created by yasmina.sorolla on 23/05/2016.
 */
public class Exercise3 {

    public static int calculateHousesWithPresent(String input) {

        HousesWithPresentCalculator calculator = new HousesWithPresentCalculator();

        calculator.calculate(input)
                .subscribe(System.out::println);

        return calculator.getNumHouses();
    }

    public static int calculateHousesWithPresentWithRobot(String input) {

        String inputEven = "";
        String inputOdd  = "";

        for(int i=0; i<input.length();i++) {
            if(i%2==0)
                inputEven= inputEven+input.charAt(i);
            else
                inputOdd= inputOdd+input.charAt(i);
        }

        HousesWithPresentCalculator calculatorEven = new HousesWithPresentCalculator();
        HousesWithPresentCalculator calculatorOdd  = new HousesWithPresentCalculator();

        calculatorEven.calculate(inputEven)
                .subscribe(System.out::println);

        calculatorOdd.calculate(inputOdd)
                .subscribe(System.out::println);


        HashSet<Pair<Integer, Integer>> visitedHouses = calculatorEven.getVisitedHouses();
        visitedHouses.addAll(calculatorOdd.getVisitedHouses());


        return visitedHouses.size();
    }
}