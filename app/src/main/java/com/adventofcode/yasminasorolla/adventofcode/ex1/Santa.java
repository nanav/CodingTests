package com.adventofcode.yasminasorolla.adventofcode.ex1;

import rx.Observable;

/**
 * Created by yasmina.sorolla on 23/05/2016.
 */

class Santa {

    int stepsUp;
    int stepsDown;
    int finalFloor;

    Santa(){
        stepsUp = stepsDown = 0;
    }

    Observable<Integer> calculateFinalFloor(String input){
        return Observable
                .from(input.trim().split(""))
                .map(step -> step(step))
                .last();

    }

    int updateFinalFloor(){
        return setFinalFloor(stepsUp-stepsDown);
    }

    int step(String step){
        switch (step){
            case "(": stepsUp++; break;
            case ")": stepsDown++; break;
        }
        return updateFinalFloor();
    }

    public int getFinalFloor(){
        return finalFloor;
    }

    public int setFinalFloor(int finalFloor){
        this.finalFloor = finalFloor;
        return finalFloor;
    }
}
