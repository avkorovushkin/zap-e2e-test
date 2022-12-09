package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class MainPage {
    //public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    //public SelenideElement seeAllToolsButton = $("a.wt-button_mode_primary");

    public SelenideElement searchField = $x("//*[@id=\"banner\"]/div/div/div/div[1]/form/div/div[1]/div/input");
    public SelenideElement searchButton = $x("//*[@id=\"banner\"]/div/div/div/div[1]/form/div/div[2]/button");
    public SelenideElement switchToMakeButton = $x("//*[@id=\"banner\"]/div/div/div/div[2]/div/div/a/button");
    public SelenideElement mainTab = $("a[href='/zap/']");
    public SelenideElement catalogTab = $("a[href='/zap/search-brand']");
    public SelenideElement aboutTab = $("a[href='/zap/about']");
}
