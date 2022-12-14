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
import ru.autoparts.zap.selentest.pages.MainPage;
import ru.autoparts.zap.selentest.pages.VendorCodeSearchResultsPage;
import ru.autoparts.zap.selentest.pages.modals.AddedToCartModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static ru.autoparts.zap.selentest.CommonElements.*;

public class CartTest {

    private final MainPage mainPage = new MainPage();
    private final VendorCodeSearchResultsPage searchResultsPage = new VendorCodeSearchResultsPage();
    private final AddedToCartModal addedToCartModal = new AddedToCartModal();
    private final CartPage cartPage = new CartPage();

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
        mainPage.searchField.sendKeys("72700BM92B");
        mainPage.searchButton.click();
        HEADER.currentH1Tag.shouldHave(text("Артикул 72700BM92B"));
        searchResultsPage.resultsRows.should(CollectionCondition.sizeGreaterThanOrEqual(3));

        searchResultsPage.firstRowQuantityInput.setValue("2");
        searchResultsPage.firstRowCartButton.click();
        addedToCartModal.continueShoppingButton.click();

        searchResultsPage.secondRowQuantityInput.setValue("1");
        searchResultsPage.secondRowCartButton.click();
        addedToCartModal.goToCartButton.click();


        cartPage.cartTable.shouldBe(visible);
        cartPage.cartRows.should(CollectionCondition.size(2));
        cartPage.firstRowDeleteButton.click();
        $x("//*[@id=\"app\"]/div[4]/div[1]/div[2]/div/div[3]/div/button/span[3]").click();
        cartPage.cartRows.should(CollectionCondition.size(1));
        //todo клик срабатывает несколько раз (по числу изначальных строк в таблице кажется) - разобраться и сделать кейсы на клик
//        cartPage.firstRowMinus.click();
//        cartPage.firstRowPrice.shouldBe(exactValue(cartPage.firstRowSum.getText()));

        //todo оформить заказ - сейчас вылетает ошибка

    }

}
