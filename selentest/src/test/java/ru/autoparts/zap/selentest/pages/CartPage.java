package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class CartPage {

    public SelenideElement cartTable = $(byTagName("table"));
    public ElementsCollection cartRows = $$(".mdc-data-table__row");
    public SelenideElement firstRowDeleteButton = $x("//*[@id=\"app\"]/main/div[3]/div/div[1]/table/tbody/tr[1]/td[10]/button");

    public SelenideElement firstRowMinus = $x("//*[@id=\"app\"]/main/div[3]/div/div[1]/table/tbody/tr/td[6]/div/i[1]");
    public SelenideElement firstRowPrice = $x("//*[@id=\"app\"]/main/div[3]/div/div[1]/table/tbody/tr/td[5]");
    public SelenideElement firstRowSum = $x("//*[@id=\"app\"]/main/div[3]/div/div[1]/table/tbody/tr/td[7]");

}
