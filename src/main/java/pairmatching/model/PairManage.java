package pairmatching.model;

public class PairManage {
    private PairMaker pairMaker;

    private PairMatchingResult pairMatchingResult;

    public PairManage(PairMaker pairMaker) {
        this.pairMaker = pairMaker;
        this.pairMatchingResult = new PairMatchingResult();
    }

    public MatchingInformation match(Level level, MatchingInformation matchingInformation){
        if(!pairMatchingResult.exist(level, matchingInformation)){
            pairMatchingResult.add(level, matchingInformation);
            return matchingInformation;
        }
        return repeatMatch(level, matchingInformation);
    }

    public MatchingInformation repeatMatch(Level level, MatchingInformation matchingInformation){
        int count = 0;
        while(count < 3){
            MatchingInformation newMatchingInformation = new MatchingInformation(matchingInformation.getMission(), pairMaker.makePair());
            if(!pairMatchingResult.exist(level, newMatchingInformation)){
                return newMatchingInformation;
            }
            count++;
        }
        throw new IllegalArgumentException("매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없습니다.");
    }


}
