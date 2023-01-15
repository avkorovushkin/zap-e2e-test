package ru.autoparts.zap.selentest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.autoparts.zap.selentest.pages.CartPage;
import ru.autoparts.zap.selentest.pages.Header;
import ru.autoparts.zap.selentest.pages.MainPage;
import ru.autoparts.zap.selentest.pages.VendorCodeSearchResultsPage;
import ru.autoparts.zap.selentest.pages.modals.AddedToCartModal;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.autoparts.zap.selentest.CommonElements.login;
import static ru.autoparts.zap.selentest.CommonElements.logout;

public class CartTest {

    private final MainPage mainPage = new MainPage();
    private final VendorCodeSearchResultsPage searchResultsPage = new VendorCodeSearchResultsPage();
    private final AddedToCartModal addedToCartModal = new AddedToCartModal();
    private final CartPage cartPage = new CartPage();
    private final Header header = new Header();

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
    public void addToCart() throws InterruptedException {
        mainPage.searchField.sendKeys("402064EA0A");
        mainPage.searchButton.click();
        //это больше не показывается
        //HEADER.currentH1Tag.shouldHave(text("Артикул 402064EA0A"));
        searchResultsPage.resultsRows.should(CollectionCondition.sizeGreaterThanOrEqual(9));

        searchResultsPage.firstRowQuantityInput.setValue("2");
        searchResultsPage.firstRowCartButton.click();
        addedToCartModal.addToCartButton.click();
        //todo это плохой гуй
        addedToCartModal.continueButton.click();

        searchResultsPage.secondRowQuantityInput.setValue("2");
        searchResultsPage.secondRowCartButton.click();
        addedToCartModal.addToCartButton.click();
        //todo это плохой гуй
        addedToCartModal.continueButton.click();

        header.cartElem.click();

        cartPage.cartTable.shouldBe(visible);
        cartPage.cartRows.should(CollectionCondition.size(2));
        cartPage.firstRowDeleteButton.click();
        $("#deletion-confirmed").click(); //принимаем факт что товар удален из корзины
        cartPage.cartRows.should(CollectionCondition.size(1));

        //todo оформить заказ - сейчас вылетает ошибка
        cartPage.firstRowDeleteButton.click();
        $("#deletion-confirmed").click();
    }

}
