package ru.autoparts.zap.selentest.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogSearchResultsPage {

    public SelenideElement resultsTable = $(byTagName("table"));
    public ElementsCollection resultsRows = $$(".mdc-data-table__row");
    public ElementsCollection cvtCells = $$(byText("CVT"));
    public ElementsCollection europeMarketCells = $$(byText("CVT"));

    public ElementsCollection treeNodes = $$(".mdc-tree-node .mdc-tree-node--root");

    public SelenideElement groupSearchButton = $(byText("Поиск по группам"));

    public SelenideElement groupTree = $(".mdc-tree");
    public SelenideElement engineNode = $(byText("Двигатель"));
    public SelenideElement engineExpandArrow = $x("//*[@id=\"app\"]/main/div[3]/div[1]/div/div/ul/li[2]/div/div");
    public SelenideElement padsElement = $(byText("Прокладки"));
    public SelenideElement gasketKitElement = $x("//*[@id=\"app\"]/main/div[3]/div[2]/div/div[2]");

    public SelenideElement searchDetailLink = $(byLinkText("A0AMA1VA0A"));

}
