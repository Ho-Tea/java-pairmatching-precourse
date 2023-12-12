package pairmatching.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PairMatching {
    private Map<Mission, List<PairMatchingResult>> pairMatchingResults;

    public PairMatching() {
        pairMatchingResults = new EnumMap<>(Mission.class);
    }






}
