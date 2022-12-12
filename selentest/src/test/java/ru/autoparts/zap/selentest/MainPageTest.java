package ru.autoparts.zap.selentest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.autoparts.zap.selentest.pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTest {
    private final MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://127.0.0.1:5173/zap/");
    }


    @Test
    public void vendorCodeSearchNotFound() {
        mainPage.searchField.sendKeys("Selenium");
        mainPage.searchField.pressEnter();
        $x("//*[@id=\"app\"]/main/h1/span").shouldHave(text("найдено 0 товаров"));
    }

    @Test
    public void testTabs() {
        mainPage.aboutTab.click();
        $x("//*[@id=\"about-banner\"]/div/div/div/div[2]/div/div/p[1]")
                .shouldHave(text("интернет-магазин автозапчастей"));
        mainPage.catalogTab.click();
        $x("//*[@id=\"app\"]/main/div[1]/h1")
                .shouldHave(text("Оригинальный каталог"));
        mainPage.mainTab.click();
        mainPage.searchField.shouldBe(visible);
    }

}
