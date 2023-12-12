package pairmatching.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PairMatchingResult {
    private Map<Level, List<MatchingInformation>> pairMatchingResults;

    public PairMatchingResult() {
        pairMatchingResults = new EnumMap<>(Level.class);
    }

    public void add(Level level, Mission mission, List<Pair> pairs) {
        level.validateContains(mission);
        if(!pairMatchingResults.containsKey(level)){
            pairMatchingResults.put(level, new ArrayList<>());
        }
        pairMatchingResults.get(level).add(new MatchingInformation(mission, pairs));
    }


    public boolean exist(Level level, Mission mission, List<Pair> pairs) {
        level.validateContains(mission);
        MatchingInformation matchingInformation = new MatchingInformation(mission, pairs);
        return !(pairMatchingResults.containsKey(level)
                && pairMatchingResults.get(level).contains(matchingInformation));
    }




}
