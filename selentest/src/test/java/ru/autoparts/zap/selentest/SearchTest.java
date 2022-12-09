package ru.autoparts.zap.selentest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.autoparts.zap.selentest.pages.MainPage;
import ru.autoparts.zap.selentest.pages.SearchResultsPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.autoparts.zap.selentest.CommonElements.*;

public class SearchTest {

    private final MainPage mainPage = new MainPage();
    private final SearchResultsPage searchResultsPage = new SearchResultsPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://127.0.0.1:5173/zap/");
        login("admin", "admin");
    }

    @AfterEach
    public void tearDown() {
        logout();
    }

    @Test
    public void searchByVendorCode() {
        mainPage.searchField.sendKeys("2342342");
        mainPage.searchButton.click();
        HEADER.currentH1Tag.shouldBe(Condition.visible).shouldHave(Condition.text("Артикул 2342342"));

        searchResultsPage.resultsTable.shouldBe(Condition.visible);
        searchResultsPage.resultsRows.should(CollectionCondition.sizeGreaterThan(3));
        searchResultsPage.resultsRows.get(0).shouldHave(Condition.text("FORD"));
    }

    @Test
    public void switchToMakeSearchButtonTest() {
        mainPage.switchToMakeButton.click();
        $(byText("Марка автомобиля")).shouldBe(Condition.visible);
    }

    @Test
    public void searchByCatalog() {

    }

}
