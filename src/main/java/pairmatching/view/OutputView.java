package pairmatching.view;

import pairmatching.constant.Exception;
import pairmatching.model.*;

import java.util.stream.Collectors;

public class OutputView {

    public void printChooseFunction() {
        System.out.println("기능을 선택하세요.");
        for (FunctionType pairMatchingFunction : FunctionType.values()) {
            System.out.println(pairMatchingFunction.getSignature() + ". " + pairMatchingFunction.getName());
        }
        System.out.println();
    }

    public void printCourseAndMission() {
        System.out.println("#############################################");
        System.out.println("과정: " + Course.BACKEND.getName() + " | " + Course.FRONTEND.getName());
        System.out.println("미션:");
        for (Level level : Level.values()) {
            System.out.println("  -" + level.getName() + ":" + level.getMissions().stream().map(mission -> mission.getName()).collect(Collectors.joining(" | ")));
        }
        System.out.println("#############################################");

    }

    public void printMatchingResult(PairMatchingResult pairMatchingResult) {
        System.out.println("페어 매칭 결과입니다.");
        for (Pair pairs : pairMatchingResult.getPairs().getPairGroup()) {
            System.out.println(pairs.getPair().stream().map(crew -> crew.getName()).collect(Collectors.joining(" : ")));
        }
        System.out.println();
    }

    public void printException(String message) {
        System.out.println(Exception.ERROR_PREFIX.getMessage() + message);
    }
}
