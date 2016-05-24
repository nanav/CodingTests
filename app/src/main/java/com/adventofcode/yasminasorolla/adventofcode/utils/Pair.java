package com.adventofcode.yasminasorolla.adventofcode.utils;


public class Pair<S, T>
        implements Comparable<Pair<S, T>> {

    final S e1;
    final T e2;

    final boolean e1Comparable;
    final boolean e2Comparable;

    public Pair( S e1,T e2) {
        this.e1 = e1;
        this.e2 = e2;

        this.e1Comparable = (e1 instanceof Comparable);
        this.e2Comparable = (e2 instanceof Comparable);
    }

    public int compareTo(Pair<S, T> o) {
        if (e1Comparable) {
            final int k = ((Comparable<S>) e1).compareTo(o.e1);
            if (k > 0) return 1;
            if (k < 0) return -1;
        }

        if (e2Comparable) {
            final int k = ((Comparable<T>) e2).compareTo(o.e2);
            if (k > 0) return 1;
            if (k < 0) return -1;
        }

        return 0;
    }

    @Override
    public boolean equals(
            Object obj) {
        if (obj instanceof Pair) {
            final Pair<S, T> o = (Pair<S, T>) obj;
            return (e1.equals(o.e1) && e2.equals(o.e2));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (e1 != null ? e1.hashCode() : 0);
        hash = 19 * hash + (e2 != null ? e2.hashCode() : 0);
        return hash;
    }
}