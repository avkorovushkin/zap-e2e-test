package ru.autoparts.zap.selentest;

import ru.autoparts.zap.selentest.pages.Header;
import ru.autoparts.zap.selentest.pages.modals.LoginModal;
import ru.autoparts.zap.selentest.pages.modals.ProfileModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.sleep;

public class CommonElements {

    public static final LoginModal LOGIN_MODAL = new LoginModal();
    public static final Header HEADER = new Header();
    public static final ProfileModal PROFILE_MODAL = new ProfileModal();

    public static void login(String login, String password) {
        HEADER.loginElem.click();
        LOGIN_MODAL.loginInput.sendKeys(login);
        LOGIN_MODAL.passwordInput.sendKeys(password);
        sleep(100);
        LOGIN_MODAL.submitButton.click();
    }

    public static void logout() {
        HEADER.profileElem.click();
        PROFILE_MODAL.logoutButton.click();
        HEADER.loginElem.shouldHave(text("Вход"));
    }


}
