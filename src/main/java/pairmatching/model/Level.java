package pairmatching.model;

import pairmatching.constant.Exception;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList(Mission.RACING_CAR, Mission.LOTTO, Mission.BASEBALL)),
    LEVEL2("레벨2", Arrays.asList(Mission.SHOPPING_BASKET, Mission.PAYMENT, Mission.SUBWAY_ROUTE_MAP)),
    LEVEL3("레벨3", Arrays.asList()),
    LEVEL4("레벨4", Arrays.asList(Mission.PERFORMANCE_IMPROVEMENT, Mission.DEPLOY)),
    LEVEL5("레벨5", Arrays.asList());

    private String name;
    private List<Mission> missions;

    Level(String name, List<Mission> missions) {
        this.name = name;
        this.missions = missions;

    }

    public static Level of(String target){
        return Arrays.stream(values())
                .filter(level -> level.name.equals(target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Exception.LEVEL.getMessage()));
    }

    public String getName() {
        return name;
    }

    public List<Mission> getMissions() {
        return missions;
    }
}