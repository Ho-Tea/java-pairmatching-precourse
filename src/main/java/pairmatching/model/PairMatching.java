package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class PairMatching {

    private List<PairMatchingResult> pairMatchingResults;
    private PairMaker pairMaker;

    public PairMatching(PairMaker pairMaker) {
        this.pairMatchingResults = new ArrayList<>();
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
            throw new IllegalArgumentException("3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없습니다");
        }
        PairMatchingResult newPairMatchingResult = new PairMatchingResult(targetResult, new Pairs(pairMaker.pair()));
        for(PairMatchingResult pairMatchingResult : pairMatchingResults){
            if(pairMatchingResult.exist(newPairMatchingResult)){
                return repeatMatch(targetResult, repeatCount--);
            }
        }
        return pairMatchingResults.add(newPairMatchingResult);
    }


}
