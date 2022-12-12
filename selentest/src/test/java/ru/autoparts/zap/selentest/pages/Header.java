package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class Header {

    public SelenideElement loginElem = $x("//*[@id=\"app-header\"]/div/div[3]/div/div");
    public SelenideElement cartElem = $x("//*[@id=\"app-header\"]/div/div[3]/div/div[1]");
    public SelenideElement cartTextSpan = $x("//*[@id=\"app-header\"]/div/div[3]/div/div[1]/a/span");
    public SelenideElement ordersTextSpan = $x("//*[@id=\"app-header\"]/div/div[3]/div/div[2]/a/span");
    public SelenideElement profileElem = $x("//*[@id=\"app-header\"]/div/div[3]/div/div[2]");

    public SelenideElement currentH1Tag = $(byTagName("h1"));

}
