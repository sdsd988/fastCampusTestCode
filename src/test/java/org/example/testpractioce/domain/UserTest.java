package org.example.testpractioce.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class UserTest {


    @Test
    @DisplayName("User의 이름이 Null이면 예외 발생한다.")
    void usernameNullThenException() {
        assertThatThrownBy(() -> new User(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("User의 이름이 공백이면 예외 발생한다.")
    void usernameBlankThenException() {
        assertThatThrownBy(() -> new User(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void parameterizedTestsExample(String username) {
        assertThatThrownBy(() -> new User(username))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2", "2, 4", "3, 6","4, 8"})
    void csvResourceExampleTest(int input, int expected) {
        assertEquals(expected, input * 2);
    }

    @TestFactory
    List<DynamicNode> testFactoryExample() {
        int size = 10;
        List<DynamicNode> result = new ArrayList<>();

        // DB에서 데이터를 가져와서 사용하거나
        // 외부 API 값을 가져와서 사용하는 경우
        for (int i = 0; i < size; i++) {
            int finalI = i;
            result.add(dynamicTest("Test CaseName" + i, () -> System.out.println("Dynamic Test # " + finalI
            )));
        }

        return result;
    }
}