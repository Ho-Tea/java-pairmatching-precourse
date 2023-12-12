package pairmatching.model;

import java.util.List;
import java.util.Objects;

public class PairMatchingResult {
    private final Mission mission;
    private final List<Pair> matchResult;

    public PairMatchingResult(Mission mission, List<Pair> matchResult) {
        this.mission = mission;
        this.matchResult = matchResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PairMatchingResult that = (PairMatchingResult) o;
        return mission == that.mission && Objects.equals(matchResult, that.matchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mission, matchResult);
    }
}
