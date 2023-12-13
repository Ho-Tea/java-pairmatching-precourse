package pairmatching.model;

import pairmatching.constant.Exception;

import java.util.Arrays;

public enum Mission {
    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    SHOPPING_BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY_ROUTE_MAP("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DEPLOY("배포");

    private final String name;

    Mission(String name) {
        this.name = name;
    }

    public static Mission of(String target){
        return Arrays.stream(values())
                .filter(mission -> mission.name.equals(target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Exception.MISSION.getMessage()));
    }

    public String getName() {
        return name;
    }
}