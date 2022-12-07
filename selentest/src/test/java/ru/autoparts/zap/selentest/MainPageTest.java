package ru.autoparts.zap.selentest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {
    MainPage mainPage = new MainPage();

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
    public void search() {
        mainPage.mainSearch.sendKeys("Selenium");
    }

    @Test
    public void goToCompanyTab() {
        mainPage.aboutCompany.click();
        $x("//*[@id=\"about-banner\"]/div/div/div/div[2]/div/div/p[1]")
                .shouldHave(text("интернет-магазин автозапчастей"));
    }


//        $("[data-test='search-input']").sendKeys("Selenium");
//        $("button[data-test='full-search-button']").click();
//
//        $("input[data-test='search-input']").shouldHave(attribute("value", "Selenium"));
//    @Test
//    public void toolsMenu() {
//        mainPage.toolsMenu.click();
//
//        $("div[data-test='main-submenu']").shouldBe(visible);
//    }
//
//    @Test
//    public void navigationToAllTools() {
//        mainPage.seeAllToolsButton.click();
//
//        $("#products-page").shouldBe(visible);
//
//        assertEquals("All Developer Tools and Products by JetBrains", Selenide.title());
//    }
}
