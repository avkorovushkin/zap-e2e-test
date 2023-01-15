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
import ru.autoparts.zap.selentest.pages.CatalogPage;
import ru.autoparts.zap.selentest.pages.CatalogSearchResultsPage;
import ru.autoparts.zap.selentest.pages.MainPage;
import ru.autoparts.zap.selentest.pages.VendorCodeSearchResultsPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.autoparts.zap.selentest.CommonElements.login;
import static ru.autoparts.zap.selentest.CommonElements.logout;

public class SearchTest {

    private final MainPage mainPage = new MainPage();
    private final CatalogPage catalogPage = new CatalogPage();
    private final VendorCodeSearchResultsPage vendorCodeSearchResultsPage = new VendorCodeSearchResultsPage();
    private final CatalogSearchResultsPage catalogSearchResultsPage = new CatalogSearchResultsPage();

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
    public void searchByVendorCode() {
        mainPage.searchField.sendKeys("2342342");
        mainPage.searchButton.click();
        //это больше не показывается
        //HEADER.currentH1Tag.shouldBe(Condition.visible).shouldHave(Condition.text("Артикул 2342342"));

        vendorCodeSearchResultsPage.resultsTable.shouldBe(Condition.visible);
        vendorCodeSearchResultsPage.resultsRows.should(CollectionCondition.sizeGreaterThan(3));
        vendorCodeSearchResultsPage.resultsRows.get(0).shouldHave(Condition.text("FORD"));
    }

    @Test
    public void switchToMakeSearchButtonTest() {
        mainPage.switchToMakeButton.click();
        $(byText("Марка автомобиля")).shouldBe(Condition.visible);
    }

    @Test
    public void searchByCatalog() throws InterruptedException {
        mainPage.catalogTab.click();
        catalogPage.nissanEntry.click();
        catalogPage.marketDropdown.click();
        catalogPage.europeMarketOption.click();

        catalogPage.modelDropdown.click();
        catalogPage.qashqaiOption.click();

        catalogPage.yearDropdown.click();
        catalogPage.year2018Option.click();

        catalogPage.driveDropdown.click();
        catalogPage.awdOption.click();

        catalogPage.transmissionDropdown.click();
        catalogPage.cvtOption.click();

        catalogPage.showCarsButton.click();

        catalogSearchResultsPage.resultsTable.shouldBe(Condition.visible);
        catalogSearchResultsPage.resultsRows.should(CollectionCondition.sizeGreaterThan(3));
        catalogSearchResultsPage.cvtCells.should(CollectionCondition.size(catalogSearchResultsPage.resultsRows.size()));
        catalogSearchResultsPage.europeMarketCells.should(CollectionCondition.size(catalogSearchResultsPage.resultsRows.size()));

        catalogSearchResultsPage.resultsRows.last().find(byText("Выбрать")).click();

        Thread.sleep(1000L);//NB без этого дерево не отрисовывается
        catalogSearchResultsPage.groupSearchButton.click();
        catalogSearchResultsPage.groupTree.shouldBe(Condition.visible);
        catalogSearchResultsPage.engineNode.shouldBe(Condition.visible);
        catalogSearchResultsPage.engineExpandArrow.click();
        catalogSearchResultsPage.padsElement.shouldBe(Condition.visible).click();

        catalogSearchResultsPage.gasketKitElement.shouldHave(Condition.text("Комплект уплотнительных прокладок двигателя ; GASKET KITS"));
        catalogSearchResultsPage.searchDetailLink.shouldBe(Condition.visible).click();
        //это больше не показывается
        //HEADER.currentH1Tag.shouldHave(Condition.text("Артикул A0AMA1VA0A"));
        vendorCodeSearchResultsPage.resultsTable.shouldBe(Condition.visible);
        vendorCodeSearchResultsPage.resultsRows.should(CollectionCondition.sizeGreaterThanOrEqual(8));

    }

}
