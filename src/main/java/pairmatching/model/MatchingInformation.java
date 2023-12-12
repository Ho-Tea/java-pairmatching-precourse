package pairmatching.model;

import java.util.Objects;

public class MatchingInformation {
    private final Mission mission;
    private final Pairs pairs;

    public MatchingInformation(Mission mission, Pairs pairs) {
        this.mission = mission;
        this.pairs = pairs;
    }

    public Mission getMission() {
        return mission;
    }

    public Pairs getPairs() {
        return pairs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchingInformation that = (MatchingInformation) o;
        return mission == that.mission && Objects.equals(pairs, that.pairs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mission, pairs);
    }
}
