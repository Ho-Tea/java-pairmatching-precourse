package pairmatching.view;

import pairmatching.model.PairMatchingFunction;

public class OutputView {

    public void printChooseFunction(){
        System.out.println("기능을 선택하세요.");
        for(PairMatchingFunction pairMatchingFunction : PairMatchingFunction.values()){
            System.out.println(pairMatchingFunction.getSignature() + ". " + pairMatchingFunction.getName());
        }
    }
}
