package pairmatching.model;

public enum PairMatchingFunction {
    PAIR_MATCHING("페어 매칭"),
    PAIR_INQUIRY("페어 조회"),
    PAIR_INITIALIZATION("페어 초기화"),
    QUIT("종료");

    private String name;

    PairMatchingFunction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
