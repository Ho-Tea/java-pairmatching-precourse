package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairMaker {
    private Course course;
    private List<Crew> crews;

    public PairMaker(Course course, List<String> crews) {
        this.course = course;
        this.crews = crew(new ArrayList<>(crews));
        validateCrewsSize(this.crews);
    }

    public List<Crew> crew(List<String> crewNames){
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        return shuffledCrew.stream()
                .map(crew -> new Crew(course, crew))
                .collect(Collectors.toList());
    }

    public List<Pair> pair(){
        validateCrewsSize(crews);
        if (crews.size() % 2 == 0) {
            return evenNumberPair(crews.size()/2, new ArrayList<>(crews));
        }
        return oddNumberPair(crews.size() / 2, new ArrayList<>(crews));
    }

    private List<Pair> evenNumberPair(int number, List<Crew> crews) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            pairs.add(new Pair(Arrays.asList(crews.remove(0), crews.remove(0))));
        }
        return pairs;
    }

    private List<Pair> oddNumberPair(int number, List<Crew> crews) {
        List<Pair> pairs = evenNumberPair(number - 1, crews);
        pairs.add(new Pair(Arrays.asList(crews.remove(0), crews.remove(0), crews.remove(0))));
        return pairs;
    }

    public void validateCrewsSize(List<Crew> crews){
        if(crews.size() < 2){
            throw new IllegalArgumentException("페어를 매칭할 수 없습니다.");
        }
    }
}
