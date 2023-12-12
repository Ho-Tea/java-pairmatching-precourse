package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PairMatching {

    public Set<Crew> crew(Course course, List<String> crewNames){
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        return shuffledCrew.stream()
                .map(crew -> new Crew(course, crew))
                .collect(Collectors.toSet());
    }


}
