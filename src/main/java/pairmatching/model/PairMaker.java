package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class PairMaker {
    private final Course course;
    private final List<String> crewNames;

    public PairMaker(Course course, List<String> crewNames) {
        this.course = course;
        this.crewNames = new ArrayList<>(crewNames);
    }

    public Pairs makePair() {
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        List<Crew> crews = shuffledCrew.stream()
                .map(crewName -> new Crew(course, crewName))
                .collect(Collectors.toList());
        if (crews.size() % 2 == 0) {
            return new Pairs(makeEvenPair(crews.size() / 2, new ArrayList<>(crews)));
        }
        return new Pairs(makeOddPair(crews.size() / 2 - 1, new ArrayList<>(crews)));
    }

    private Set<Pair> makeEvenPair(int number, List<Crew> crews) {
        Set<Pair> pairs = new HashSet<>();
        for (int i = 0; i < number; i++) {
            pairs.add(new Pair(Arrays.asList(crews.remove(0), crews.remove(0))));
        }
        return pairs;
    }

    private Set<Pair> makeOddPair(int number, List<Crew> crews) {
        Set<Pair> pairs = makeEvenPair(number, crews);
        pairs.add(new Pair(Arrays.asList(crews.remove(0), crews.remove(0), crews.remove(0))));
        return pairs;
    }
}
