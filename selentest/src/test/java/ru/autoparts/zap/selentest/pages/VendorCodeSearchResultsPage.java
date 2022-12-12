package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class VendorCodeSearchResultsPage {

    public SelenideElement resultsTable = $(byTagName("table"));
    public ElementsCollection resultsRows = $$(".mdc-data-table__row");

    public SelenideElement firstRowQuantityInput = $x("//*[@id=\"3134630153\"]/input");
    public SelenideElement secondRowQuantityInput = $x("//*[@id=\"3134967730\"]/input");
    public SelenideElement firstRowCartButton = $x("//*[@id=\"app\"]/main/div[2]/div/div/div/div[1]/table/tbody/tr[1]/td[7]/button");
    public SelenideElement secondRowCartButton = $x("//*[@id=\"app\"]/main/div[2]/div/div/div/div[1]/table/tbody/tr[2]/td[7]/button");
}
