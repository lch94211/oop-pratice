package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

//1.비밀번호는 최소 8자 이상 12자 이하여야 한다.
//2.비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
//3.경게조건에 대한 테스트 코드를 작성해야 한다.
public class PassWordValidatorTest {

    @DisplayName("비밀번호가 최소 8자이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest(){
        assertThatCode( () -> PassWordValidator.validate("serverwizard"))
                .doesNotThrowAnyException(); // 해당부분이 호출됫을때 입셋션이 발생하지 않는다 그러면 테스트가 통과할 것.
    }
    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcc", "aabbccddeeffg"})
    void validatePasswordTest2(String password) {

        assertThatCode(()-> PassWordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
