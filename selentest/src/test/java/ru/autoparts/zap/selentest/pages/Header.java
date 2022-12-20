package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class Header {

    public SelenideElement loginElem = $("#open-login");
    public SelenideElement cartElem = $("#open-cart");
    public SelenideElement profileElem = $("#open-profile-dialog");
    ;
    public SelenideElement currentH1Tag = $(byTagName("h1"));

}
