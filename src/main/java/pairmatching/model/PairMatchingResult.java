package pairmatching.model;

public class PairMatchingResult {
    private Level level;
    private Mission mission;
    private Pairs pairs;

    public PairMatchingResult(Level level, Mission mission, Pairs pairs) {
        this.level = level;
        this.mission = mission;
        this.pairs = pairs;
    }

    public PairMatchingResult(PairMatchingResult pairMatchingResult, Pairs pairs) {
        this.level = pairMatchingResult.level;
        this.mission = pairMatchingResult.mission;
        this.pairs = pairs;
    }



    public boolean exist(PairMatchingResult target){
        return level.equals(target.level)
                && pairs.anyMatch(target.pairs);
    }
}
