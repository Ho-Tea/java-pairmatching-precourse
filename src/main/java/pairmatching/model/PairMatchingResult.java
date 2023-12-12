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

    public boolean exist(Level level, Pairs pairs){
        return this.level.equals(level)
                && pairs.anyMatch(pairs);
    }

}
