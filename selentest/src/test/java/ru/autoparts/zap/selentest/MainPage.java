package ru.autoparts.zap.selentest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

// page_url = https://www.jetbrains.com/
public class MainPage {
    //public SelenideElement searchButton = $("[data-test='site-header-search-action']");
    //public SelenideElement seeAllToolsButton = $("a.wt-button_mode_primary");

    public SelenideElement mainSearch = $x("//*[@id=\"banner\"]/div/div/div/div[1]/form/div/div[1]/div/input");
    public SelenideElement aboutCompany = $x("//*[@id=\"app-header\"]/div/nav/div/div[3]/a");
}
