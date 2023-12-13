package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InputView {
    private static final String SEPARATOR = ",";

    public String inputFunction(){
        String signature = Console.readLine();
        validateNullAndEmpty(signature);
        validateSingleLetter(signature);
        return signature;
    }

    public List<String> inputCourseAndMission(){
        System.out.println("과정, 레벨, 미션을 선택하세요.\n" +
                "ex) 백엔드, 레벨1, 자동차경주");
        String input = Console.readLine();
        validateNullAndEmpty(input);
        return Arrays.stream(input.split(SEPARATOR))
                .map(courseAndMission -> courseAndMission.trim())
                .collect(Collectors.toList());
    }

    public String inputRetryMatching(){
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
                "네 | 아니오");
        String input = Console.readLine();
        validateNullAndEmpty(input);
        return input;
    }
    private void validateNullAndEmpty(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("null 이거나 길이가 없는 문자열 입니다.");
        }
    }

    private void validateSingleLetter(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("문자열의 크기는 한개로 이루어져야 합니다.");
        }
    }
}
