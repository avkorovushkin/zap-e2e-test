package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    public SelenideElement cartTable = $(byTagName("table"));
    public ElementsCollection cartRows = $$(".mdc-data-table__row");
    public SelenideElement firstRowDeleteButton = $("#app > main > div.mt-3.dark > div > div.mdc-data-table__table-container > table > tbody > tr:nth-child(1) > td:nth-child(10) > button");
    public SelenideElement firstRowMinus = $("#app > main > div.mt-3.dark > div > div.mdc-data-table__table-container > table > tbody > tr:nth-child(1) > td:nth-child(6) > div > i:nth-child(1)");
    public SelenideElement firstRowPrice = $("#app > main > div.mt-3.dark > div > div.mdc-data-table__table-container > table > tbody > tr:nth-child(1) > td:nth-child(5)");
    public SelenideElement firstRowSum = $("#app > main > div.mt-3.dark > div > div.mdc-data-table__table-container > table > tbody > tr:nth-child(1) > td:nth-child(7)");

}
