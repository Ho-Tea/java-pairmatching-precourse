package pairmatching.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LevelTest {

    @Test
    @DisplayName("특정 레벨에 포함되지 않은 미션이 넘어올 시 예외가 발생한다.")
    void validateContains(){
        Level level = Level.LEVEL1;
        assertThatThrownBy(() -> level.validateContains(Mission.PAYMENT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("해당 레벨에 존재하지 않는 미션입니다.");
    }

}