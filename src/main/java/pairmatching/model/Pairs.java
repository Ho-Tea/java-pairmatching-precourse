package pairmatching.model;

import java.util.HashSet;
import java.util.Set;

public class Pairs {
    private final Set<Pair> pairs;

    public Pairs(Set<Pair> pairs) {
        this.pairs = new HashSet<>(pairs);
    }

}
