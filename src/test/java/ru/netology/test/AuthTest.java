package ru.netology.test;

import lombok.var;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.date.DataGenerator.Registration.*;

public class AuthTest {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999/");
    }

    @Test
        //TODO Тест на наличие пользователя;
    void shouldCheckThePresenceOfTheUser() {
        var validUser = generateUser("active");
        $("[data-test-id=login] input").setValue(validUser.getLogin());
        $("[data-test-id=password] input").setValue(validUser.getPassword());
        $("button[data-test-id=action-login]").click();
        $(withText("Личный кабинет")).shouldBe(visible);
    }
}
