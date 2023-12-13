package pairmatching.constant;

public enum Exception {
    ERROR_PREFIX("[ERROR] "),
    COURSE("해당하는 과정이 존재하지 않습니다"),
    DECISION_RE_MATCH("알맞지 않은 재매칭 결정 문자 입니다"),
    FUNCTION_TYPE("기능 목록에 해당하지 않는 입력입니다."),
    LEVEL("해당하는 레벨이 존재하지 않습니다."),
    MISSION("해당하는 미션이 존재하지 않습니다."),
    PAIR_SIZE("페어는 2인 혹은 3인으로 구성되어야 합니다."),
    CREW_SIZE("페어를 매칭할 수 없습니다."),
    PAIR_REMATCH("3회 시도까지 매칭이 되지 않거나 매칭을 할 수 있는 경우의 수가 없습니다"),
    NOT_MATCH_RESULT("매칭 이력이 없습니다.")

    ;

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
