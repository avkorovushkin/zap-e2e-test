package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage {

    public SelenideElement nissanEntry = $("a[href='/zap/search-brand/NISSAN201809']");
    public SelenideElement marketDropdown = $x("//*[@id=\"app\"]/main/div[2]/div[1]/div/div[1]/div[2]/div");
    public SelenideElement modelDropdown = $x("//*[@id=\"app\"]/main/div[2]/div[1]/div/div[2]/div[2]/div");
    public SelenideElement yearDropdown = $x("//*[@id=\"app\"]/main/div[2]/div[1]/div/div[3]/div[2]/div");
    public SelenideElement driveDropdown = $x("//*[@id=\"app\"]/main/div[2]/div[1]/div/div[4]/div[2]/div");
    public SelenideElement transmissionDropdown = $x("//*[@id=\"app\"]/main/div[2]/div[1]/div/div[8]/div[2]/div");
    public SelenideElement europeMarketOption = $(byText("Europe (LHD)"));
    public SelenideElement qashqaiOption = $(byText("QASHQAI"));
    public SelenideElement year2018Option = $(byText("2018"));
    public SelenideElement awdOption = $(byText("4WD"));
    public SelenideElement cvtOption = $(byText("CVT"));
    public SelenideElement showCarsButton = $(byText("Показать автомобили"));
}
