package ru.autoparts.zap.selentest.pages.modals;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class AddedToCartModal {

    public SelenideElement continueShoppingButton = $("#continue-shopping");
    public SelenideElement goToCartButton = $("#go-to-cart");
    public SelenideElement closeButton = $(".mdc-dialog__close");
    public SelenideElement addToCartButton = $("#add-to-cart");
    //?? почему так?
    public SelenideElement continueButton = $("#deletion-confirmed");

}
