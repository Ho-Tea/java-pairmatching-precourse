package pairmatching.model;

import pairmatching.constant.Exception;

import java.util.Arrays;

public enum DecisionReMatch {
    RETRY("네"),
    NOT_RETRY("아니오");

    private String signature;

    DecisionReMatch(String signature) {
        this.signature = signature;
    }

    public static DecisionReMatch of(String target){
        return Arrays.stream(values())
                .filter(decisionReMatch -> decisionReMatch.signature.equals(target))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Exception.DECISION_RE_MATCH.getMessage()));
    }

    public String getSignature() {
        return signature;
    }
}
