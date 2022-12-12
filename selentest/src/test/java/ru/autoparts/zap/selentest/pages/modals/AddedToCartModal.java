package ru.autoparts.zap.selentest.pages.modals;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AddedToCartModal {

    public SelenideElement popupWindow = $(".mdc-dialog__surface");
    public SelenideElement continueShoppingButton = $(byText("Продолжить покупки"));
    public SelenideElement goToCartButton = $(byText("Перейти в корзину"));


}
