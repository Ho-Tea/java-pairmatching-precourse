package pairmatching.model;

import java.util.List;

public class PairMatchingResult {
    private final Mission mission;
    private final List<Pair> matchResult;

    public PairMatchingResult(Mission mission, List<Pair> matchResult) {
        this.mission = mission;
        this.matchResult = matchResult;
    }
}
