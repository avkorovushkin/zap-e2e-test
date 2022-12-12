package ru.autoparts.zap.selentest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.autoparts.zap.selentest.CommonElements.*;

public class LoginTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://127.0.0.1:5173/zap/");
    }


    @Test
    public void loginSuccess() {

        login();

        HEADER.cartElem.shouldBe(visible);
        HEADER.cartTextSpan.shouldHave(text("Корзина"));
        //HEADER.ordersTextSpan.shouldBe(visible).shouldHave(text("Заказы"));

        logout();
    }

    @Test
    public void loginFail() {
        loginBadCredentials();
        $(byText("Неверный логин или пароль")).shouldBe(visible);

    }
}
