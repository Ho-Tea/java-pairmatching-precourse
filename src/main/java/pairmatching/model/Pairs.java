package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pairs {
    private List<Pair> pairs;

    public Pairs(List<Pair> pairs) {
        this.pairs = new ArrayList<>(pairs);
    }

    public boolean anyMatch(Pairs target) {
        return this.pairs.stream()
                .filter(pair -> target.pairs.contains(pair))
                .findAny()
                .isPresent();

    }
}
