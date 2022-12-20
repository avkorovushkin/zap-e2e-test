package ru.autoparts.zap.selentest.pages.modals;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginModal {

    public SelenideElement loginInput = $("#login-name");
    public SelenideElement passwordInput = $("#login-password");
    public SelenideElement submitButton = $("#auth-button");

}
