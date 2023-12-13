package pairmatching.model;

import pairmatching.constant.Exception;

import java.util.List;

public class PairMatching {

    private List<PairMatchingResult> pairMatchingResults;
    private PairMaker pairMaker;

    public PairMatching(List<PairMatchingResult> pairMatchingResults, PairMaker pairMaker) {
        this.pairMatchingResults = pairMatchingResults;
        this.pairMaker = pairMaker;
    }

    public boolean match(PairMatchingResult targetResult){
        for(PairMatchingResult pairMatchingResult : pairMatchingResults){
            if(pairMatchingResult.exist(targetResult)){
                return repeatMatch(targetResult, 3);
            }
        }
        return pairMatchingResults.add(targetResult);
    }

    public boolean repeatMatch(PairMatchingResult targetResult, int repeatCount){
        if(repeatCount == 0){
            throw new IllegalArgumentException(Exception.PAIR_REMATCH.getMessage());
        }
        PairMatchingResult newResult = new PairMatchingResult(targetResult, new Pairs(pairMaker.pair()));
        for(PairMatchingResult pairMatchingResult : pairMatchingResults){
            if(pairMatchingResult.exist(newResult)){
                return repeatMatch(targetResult, repeatCount - 1);
            }
        }
        return pairMatchingResults.add(newResult);
    }

}
