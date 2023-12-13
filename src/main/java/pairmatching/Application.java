package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.view.FileReaderView;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class Application {
    public static void main(String[] args) {

        new PairMatchingController(new InputView(), new OutputView(), new FileReaderView()).start();
        // TODO 구현 진행
    }
}
