package pairmatching.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pairs {
    private List<Pair> pairGroup;

    public Pairs(List<Pair> pairGroup) {
        this.pairGroup = new ArrayList<>(pairGroup);
    }

    public boolean anyMatch(Pairs target) {
        return this.pairGroup.stream()
                .filter(pair -> target.pairGroup.contains(pair))
                .findAny()
                .isPresent();
    }

    public List<Pair> getPairGroup() {
        return new ArrayList<>(pairGroup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pairs pairs = (Pairs) o;
        return Objects.equals(pairGroup, pairs.pairGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pairGroup);
    }
}
