package subway.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineOptionTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("사용자가 1, 2, 3, B를 입력하면 해당하는 기능을 반환한다.")
    @Test
    void getLineOption() {
        String input = "1";

        LineOption option = LineOption.getOption(input);

        assertThat(option).isEqualTo(LineOption.CREATE);
    }

    @DisplayName("목록에 없는 옵션을 선택할 경우 예외가 발생한다.")
    @Test
    void lineOptionException() {
        String input = "1241";

        assertThatThrownBy(() -> LineOption.getOption(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("옵션이 CREATE 상태이면 true를 반환한다.")
    @Test
    void getCreateOption() {
        String input = "1";

        LineOption option = LineOption.getOption(input);

        assertThat(option.isCreate()).isTrue();
    }

    @DisplayName("옵션이 DELETE 상태이면 true를 반환한다.")
    @Test
    void getDeleteOption() {
        String input = "2";

        LineOption option = LineOption.getOption(input);

        assertThat(option.isDelete()).isTrue();
    }

    @DisplayName("옵션이 Read 상태이면 true를 반환한다.")
    @Test
    void getReadOption() {
        String input = "3";

        LineOption option = LineOption.getOption(input);

        assertThat(option.isRead()).isTrue();
    }

    @DisplayName("옵션이 Back 상태이면 true를 반환한다.")
    @Test
    void getBackOption() {
        String input = "B";

        LineOption option = LineOption.getOption(input);

        assertThat(option.isBack()).isTrue();
    }
}
