package pairmatching.model;

import java.util.Arrays;

public enum FunctionType {
    PAIR_MATCHING("페어 매칭", "1"),
    PAIR_INQUIRY("페어 조회", "2"),
    PAIR_INITIALIZATION("페어 초기화", "3"),
    QUIT("종료", "Q");

    private String name;
    private String signature;

    FunctionType(String name, String signature) {
        this.name = name;
        this.signature = signature;
    }

    public static FunctionType of(String signature){
        return Arrays.stream(values())
                .filter(function -> function.signature.equals(signature))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("기능 목록에 해당하지 않는 입력입니다."));
    }

    public String getName() {
        return name;
    }

    public String getSignature() {
        return signature;
    }
}
