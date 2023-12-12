package pairmatching.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PairTest {

    @Test
    @DisplayName("페어가 2인 혹은 3인으로 이루어지지 않을 시 예외가 발생한다.")
    void validateSize() {
        assertAll(
                () -> assertThatThrownBy(
                        () -> new Pair(
                                Arrays.asList(
                                        new Crew(Course.BACKEND, "tobi")))
                ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("페어는 2인 혹은 3인으로 구성되어야 합니다."),
                () -> assertThatThrownBy(
                        () -> new Pair(
                                Arrays.asList(
                                        new Crew(Course.BACKEND, "tobi"),
                                        new Crew(Course.BACKEND, "habi"),
                                        new Crew(Course.BACKEND, "gobi"),
                                        new Crew(Course.BACKEND, "hebi")))
                ).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("페어는 2인 혹은 3인으로 구성되어야 합니다."));

    }

}