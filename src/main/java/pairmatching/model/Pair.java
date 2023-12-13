package pairmatching.model;

import pairmatching.constant.Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pair {
    private final int MIN_SIZE = 2;
    private final int MAX_SIZE = 3;
    private final List<Crew> pair;

    public Pair(List<Crew> pair) {
        validateSize(pair);
        this.pair = new ArrayList<>(pair);
    }

    private void validateSize(List<Crew> pair){
        if (pair.size() != MIN_SIZE && pair.size() != MAX_SIZE){
            throw new IllegalArgumentException(Exception.PAIR_SIZE.getMessage());
        }
    }

    public List<Crew> getPair() {
        return new ArrayList<>(pair);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair1 = (Pair) o;
        return MIN_SIZE == pair1.MIN_SIZE && MAX_SIZE == pair1.MAX_SIZE && Objects.equals(pair, pair1.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MIN_SIZE, MAX_SIZE, pair);
    }
}
