package pairmatching.controller;

import pairmatching.constant.Exception;
import pairmatching.model.*;
import pairmatching.view.FileReaderView;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class PairMatchingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final FileReaderView fileReaderView;
    private Map<FunctionType, Supplier> function;
    private List<PairMatchingResult> pairMatchingResults;
    private Course course;
    private Mission mission;
    private Level level;

    public PairMatchingController(InputView inputView, OutputView outputView, FileReaderView fileReaderView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.fileReaderView = fileReaderView;
        this.pairMatchingResults = new ArrayList<>();
        this.function = initFunction();
    }

    private Map<FunctionType, Supplier> initFunction() {
        Map<FunctionType, Supplier> function = new EnumMap<>(FunctionType.class);
        function.put(FunctionType.PAIR_MATCHING, () -> startPairMatching());
        function.put(FunctionType.PAIR_INQUIRY, () -> inquiryPairMatchingResult());
        function.put(FunctionType.PAIR_INITIALIZATION, () -> initializePairMatchingResults());
        return function;
    }

    public void start() {
        outputView.printChooseFunction();
        FunctionType pairMatchingFunction = attempt(() -> FunctionType.of(attempt(() -> inputView.inputFunction())));
        if(!pairMatchingFunction.equals(FunctionType.QUIT)){
            outputView.printCourseAndMission();
            attempt(() -> injectCourseAndMission());
            attempt(() -> function.get(pairMatchingFunction).get());
            start();
        }
    }

    private boolean initializePairMatchingResults() {
        pairMatchingResults.clear();
        return true;
    }
    private boolean injectCourseAndMission() {
        List<String> courseAndMission = attempt(() -> inputView.inputCourseAndMission());
        course = Course.of(courseAndMission.get(0));
        level = Level.of(courseAndMission.get(1));
        mission = Mission.of(courseAndMission.get(2));
        return true;
    }

    private boolean startPairMatching() {
        PairMaker pairMaker = new PairMaker(course, fileReaderView.read(course));
        PairMatching pairMatching = new PairMatching(pairMatchingResults, pairMaker);
        PairMatchingResult pairMatchingResult = new PairMatchingResult(level, mission, new Pairs(pairMaker.pair()));
        if (pairMatching.match(pairMatchingResult)) {
            outputView.printMatchingResult(pairMatchingResult);
            return true;
        }
        return retryPairMatching(pairMatchingResult);
    }


    private boolean retryPairMatching(PairMatchingResult pairMatchingResult) {
        DecisionReMatch decision = attempt(() -> DecisionReMatch.of(attempt(() -> inputView.inputRetryMatching())));
        if (decision.equals(DecisionReMatch.RETRY)) {
            pairMatchingResults.remove(pairMatchingResult);
            return startPairMatching();
        }
        injectCourseAndMission();
        return startPairMatching();
    }

    private boolean inquiryPairMatchingResult() {
        PairMaker pairMaker = new PairMaker(course, fileReaderView.read(course));
        PairMatchingResult pairMatchingResult = new PairMatchingResult(level, mission, new Pairs(pairMaker.pair()));
        if (pairMatchingResults.contains(pairMatchingResult)) {
            outputView.printMatchingResult(pairMatchingResult);
            return true;
        }
        outputView.printException(Exception.NOT_MATCH_RESULT.getMessage());
        return false;
    }

    private <T> T attempt(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return attempt(inputSupplier);
        }
    }
}
