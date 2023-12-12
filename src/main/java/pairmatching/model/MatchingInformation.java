package pairmatching.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class MatchingInformation {
    private final Mission mission;
    private final Set<Pair> matchResult;

    public MatchingInformation(Mission mission, List<Pair> matchResult) {
        this.mission = mission;
        this.matchResult = new HashSet<>(matchResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchingInformation that = (MatchingInformation) o;
        return mission == that.mission && Objects.equals(matchResult, that.matchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mission, matchResult);
    }
}
