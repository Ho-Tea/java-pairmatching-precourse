package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class PairMatching {
    private Map<Level, List<PairMatchingResult>> pairMatchingResults;

    public PairMatching() {
        pairMatchingResults = new EnumMap<>(Level.class);
    }


    public void match(Course course, List<String> crewNames){
        List<Pair> pairs = makePair(course, crewNames);



    }

    private List<Pair> makePair(Course course, List<String> crewNames){
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        List<Crew> crews = shuffledCrew.stream()
                .map(crewName -> new Crew(course, crewName))
                .collect(Collectors.toList());
        if(crews.size() % 2 == 0){
            return makeEvenPair(crews.size()/2, new ArrayList<>(crews));
        }
        return makeOddPair(crews.size()/2 - 1, new ArrayList<>(crews));
    }

    private List<Pair> makeEvenPair(int number, List<Crew> crews){
        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < number; i++){
            pairs.add(new Pair(Arrays.asList(crews.remove(0), crews.remove(0))));
        }
        return pairs;
    }

    private List<Pair> makeOddPair(int number, List<Crew> crews){
        List<Pair> pairs = makeEvenPair(number, crews);
        pairs.add(new Pair(Arrays.asList(crews.remove(0), crews.remove(0), crews.remove(0))));
        return pairs;
    }





}
