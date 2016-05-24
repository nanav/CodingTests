package com.adventofcode.yasminasorolla.adventofcode.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import rx.Observable;

/**
 * Created by yasmina.sorolla on 23/05/2016.
 */

public class WrappingPaperCalculator {

    int surfaceNeeded;

    final List<Integer> inputsAux =  Arrays.asList(3,2,2);

    public WrappingPaperCalculator() {
        surfaceNeeded = 0;
    }

    public Observable<Integer> calculateWrappingPaper(List<Integer> input) {

        Collections.sort(input);

        List<Integer> inputsTransformed = new ArrayList<>(input);
        inputsTransformed.add(inputsTransformed.remove(0));


        /*System.out.println("input"+input);
        System.out.println("inputsTransformed"+inputsTransformed);
        System.out.println("inputsAux"+inputsAux);*/

        return Observable.zip(
                Observable.zip(
                        Observable.from(input),
                        Observable.from(inputsTransformed),
                        (x,y) -> x*y),
                Observable.from(inputsAux),
                (x,y) -> x*y )

                .reduce((x,y) -> x+y)
                .map(x -> setSurfaceNeeded(x));

    }

/*    public Observable<Integer> calculateWrappingPaper(String inputStr) {

        List<Integer> input =
                Observable
                        .from(inputStr.split("\n"))
                        .map(dimension -> {
                            return Observable
                                    .from(dimension.split("x"))
//                                    .cast(Integer.class)
//                                    .groupBy(x -> x)
                                    ;
                        });

        Collections.sort(input);

        List<Integer> inputsTransformed = new ArrayList<>(input);
        inputsTransformed.add(inputsTransformed.remove(0));


        /*System.out.println("input"+input);
        System.out.println("inputsTransformed"+inputsTransformed);
        System.out.println("inputsAux"+inputsAux);*/

 /*       return Observable.zip(
                Observable.zip(
                        Observable.from(input),
                        Observable.from(inputsTransformed),
                        (x,y) -> x*y),
                Observable.from(inputsAux),
                (x,y) -> x*y )

                .reduce((x,y) -> x+y)
                .map(x -> setSurfaceNeeded(x));

    }*/

    public int getSurfaceNeeded() {
        return surfaceNeeded;
    }

    public int setSurfaceNeeded(int surfaceNeeded) {
        this.surfaceNeeded = surfaceNeeded;
        return surfaceNeeded;
    }
}