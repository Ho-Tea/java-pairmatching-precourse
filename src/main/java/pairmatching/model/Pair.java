package pairmatching.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Pair {
    private final int MIN_SIZE = 2;
    private final int MAX_SIZE = 3;
    private final Set<Crew> pair;

    public Pair(List<Crew> pair) {
        validateSize(pair);
        this.pair = new HashSet<>(pair);
    }

    private void validateSize(List<Crew> pair){
        if (pair.size() != MIN_SIZE && pair.size() != MAX_SIZE){
            throw new IllegalArgumentException("페어는 2인 혹은 3인으로 구성되어야 합니다.");
        }
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
