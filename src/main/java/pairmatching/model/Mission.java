package pairmatching.model;

public enum Mission {
    RACING_CAR("자동차 경주"),
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
}
