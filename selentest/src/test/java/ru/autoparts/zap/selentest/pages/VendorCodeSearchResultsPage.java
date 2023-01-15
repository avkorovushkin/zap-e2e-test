package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VendorCodeSearchResultsPage {

    public SelenideElement resultsTable = $(byTagName("table"));
    public ElementsCollection resultsRows = $$(".mdc-data-table__row");
    public SelenideElement firstRowQuantityInput = $("#ZAP0293050846623quantity");
    public SelenideElement secondRowQuantityInput = $("#ZAP0403050846623quantity");
    public SelenideElement firstRowCartButton = $("#ZAP0293050846623cart");
    public SelenideElement secondRowCartButton = $("#ZAP0403050846623cart");
}
