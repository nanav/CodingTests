package com.adventofcode.yasminasorolla.adventofcode.ex3;

import com.adventofcode.yasminasorolla.adventofcode.utils.Pair;

import java.util.HashSet;

import rx.Observable;

/**
 * Created by yasmina.sorolla on 24/05/2016.
 */
public class HousesWithPresentCalculator {

    public int numHouses = 1;;

    private HashSet<Pair<Integer,Integer>> visitedHouses;

    private int lastPosX,lastPosY = 0;

    public HousesWithPresentCalculator() {
        visitedHouses = new HashSet<Pair<Integer,Integer>>();
        visitedHouses.add(new Pair<Integer,Integer>(0,0));
    }

    Observable<Integer> calculate(String input) {

        return Observable.from(input.trim().split(""))
                .map(x -> nextHouse(x))
                .last()
                .map(list -> list.size())
                .map(numElements -> updateNumHouses(numElements))
                ;

    }

    private HashSet<Pair<Integer,Integer>> nextHouse(String dir) {

        switch (dir) {
            case "^":lastPosY--; //System.out.println("d");
                break;
            case "v":lastPosY++; //System.out.println("u");
                break;
            case ">":lastPosX++; //System.out.println("r");
                break;
            case "<":lastPosX--; //System.out.println("l");
                break;
            default: System.out.println("default!"+dir);
        }

        visitedHouses.add(new Pair<Integer,Integer>(lastPosX,lastPosY));

        return visitedHouses;
    }

    public int getNumHouses() {
        return numHouses;
    }

    public void setNumHouses(int numHouses) {
        this.numHouses = numHouses;
    }

    public int updateNumHouses(int numHouses) {
        setNumHouses(numHouses);
        return numHouses;
    }

    public HashSet<Pair<Integer, Integer>> getVisitedHouses() {
        return visitedHouses;
    }

}