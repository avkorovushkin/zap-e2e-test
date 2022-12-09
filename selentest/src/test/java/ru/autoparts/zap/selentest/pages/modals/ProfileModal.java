package ru.autoparts.zap.selentest.pages.modals;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProfileModal {

    public SelenideElement logoutButton = $x("//*[@id=\"app\"]/div[1]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div");

}
