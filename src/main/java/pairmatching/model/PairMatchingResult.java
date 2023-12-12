package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class PairMatchingResult {
    private Level level;
    private Mission mission;
    private List<Pair> pairs;

    public PairMatchingResult(Level level, Mission mission, List<Pair> pairs) {
        this.level = level;
        this.mission = mission;
        this.pairs = new ArrayList<>(pairs);
    }

    public boolean exist(Level level, List<Pair> pairs){
        if(this.level.equals(level) && this.pairs.eq(pairs)){

        }
    }

}
