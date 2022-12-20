package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class VendorCodeSearchResultsPage {

    public SelenideElement resultsTable = $(byTagName("table"));
    public ElementsCollection resultsRows = $$(".mdc-data-table__row");

    public SelenideElement firstRowQuantityInput = $x("/html/body/div[1]/main/div[2]/div/div/div/div[1]/table/tbody/tr[1]/td[6]/div/input");
    public SelenideElement secondRowQuantityInput = $x("/html/body/div[1]/main/div[2]/div/div/div/div[1]/table/tbody/tr[2]/td[6]/div/input");
    public SelenideElement firstRowCartButton = $("#app > main > div.row > div > div > div > div.mdc-data-table__table-container > table > tbody > tr:nth-child(1) > td:nth-child(7) > button");
    public SelenideElement secondRowCartButton = $("#app > main > div.row > div > div > div > div.mdc-data-table__table-container > table > tbody > tr:nth-child(2) > td:nth-child(7) > button");
}
