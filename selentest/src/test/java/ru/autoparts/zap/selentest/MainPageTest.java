package ru.autoparts.zap.selentest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.autoparts.zap.selentest.pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static ru.autoparts.zap.selentest.CommonElements.*;

public class MainPageTest {
    private final MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open(Configuration.baseUrl);
        login();
    }

    @AfterEach
    public void tearDown() {
        logout();
    }


    @Test
    public void vendorCodeSearchNotFound() {
        mainPage.searchField.sendKeys("Selenium");
        mainPage.searchField.pressEnter();
        $x("//*[@id=\"app\"]/main/h3/span").shouldHave(text("Найдено предложений: 0"));
    }

    @Test
    public void testTabs() {
        mainPage.aboutTab.click();
        $x("//*[@id=\"about-banner\"]/div/div/div/div[2]/div/div/p[1]")
                .shouldHave(text("интернет-магазин автозапчастей"));
        mainPage.catalogTab.click();
        HEADER.currentH1Tag.shouldHave(text("Оригинальный каталог"));
        mainPage.mainTab.click();
        mainPage.searchField.shouldBe(visible);
    }

}
