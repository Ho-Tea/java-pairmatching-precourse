package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalArgumentException("페어는 2인 혹은 3인으로 구성되어야 합니다.");
        }
    }
}
