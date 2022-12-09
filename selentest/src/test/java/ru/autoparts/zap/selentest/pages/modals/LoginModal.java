package ru.autoparts.zap.selentest.pages.modals;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginModal {

    public SelenideElement loginInput = $("#login-name");
    public SelenideElement passwordInput = $("#login-password");
    public SelenideElement submitButton = $x("//*[@id=\"app\"]/div[2]/div[1]/div[2]/div[2]/button/span[3]");

}
