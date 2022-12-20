package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement searchField = $("#search-input > input");
    public SelenideElement searchButton = $("#search-button");
    ;
    public SelenideElement switchToMakeButton = $("#search-by-make");
    public SelenideElement mainTab = $("a[href='/zap/']");
    public SelenideElement catalogTab = $("a[href='/zap/search-brand']");
    public SelenideElement aboutTab = $("a[href='/zap/about']");
}
