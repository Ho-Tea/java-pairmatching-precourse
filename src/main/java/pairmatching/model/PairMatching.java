package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class PairMatching {

    public List<Crew> crew(Course course, List<String> crewNames){
        List<String> shuffledCrew = Randoms.shuffle(crewNames);
        return shuffledCrew.stream()
                .map(crew -> new Crew(course, crew))
                .collect(Collectors.toList());
    }



    public void validateCrewsSize(List<Crew> crews){
        if(crews.size() < 2){
            throw new IllegalArgumentException("페어를 매칭할 수 없습니다.");
        }
    }



}
