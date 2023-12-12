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

    public void add(Level level, MatchingInformation matchingInformation) {
        level.validateContains(matchingInformation.getMission());
        if(!pairMatchingResults.containsKey(level)){
            pairMatchingResults.put(level, new ArrayList<>());
        }
        pairMatchingResults.get(level).add(matchingInformation);
    }


    public boolean exist(Level level, MatchingInformation matchingInformation) {
        level.validateContains(matchingInformation.getMission());
        return !(pairMatchingResults.containsKey(level)
                && pairMatchingResults.get(level).contains(matchingInformation));
    }




}
