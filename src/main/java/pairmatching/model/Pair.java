package pairmatching.model;

import java.util.HashSet;
import java.util.Set;

public class Pair {
    private final int MIN_SIZE = 2;
    private final int MAX_SIZE = 3;
    private final Set<Crew> pair;

    public Pair(Set<Crew> pair) {
        validateSize(pair);
        this.pair = new HashSet<>(pair);
    }

    private void validateSize(Set<Crew> pair){
        if (pair.size() != MIN_SIZE && pair.size() != MAX_SIZE){
            throw new IllegalArgumentException("페어는 2인 혹은 3인으로 구성되어야 합니다.");
        }
    }
}
