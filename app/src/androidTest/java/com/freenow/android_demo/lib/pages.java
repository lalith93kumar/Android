package com.freenow.android_demo.lib;

public class pages extends locator {

    public void login(String user, String password) throws InterruptedException {
        USERNAME_FIELD.sendKeys(user);
        PASSWORD_FIELD.sendKeys(password);
        LOGIN_BUTTON.click();
        Thread.sleep(1000);
    }

    public void logout() {
        SIDE.click();
        LOGOUT_BUTTON.click();
    }

    public void contact(String searchValue, String contactName) throws InterruptedException {
        SEARCH_DRIVER_FIELD.sendKeys(searchValue);
        Thread.sleep(1000);
        contactSuggestion(contactName).select(contactName);
        Thread.sleep(2000);
    }
}
