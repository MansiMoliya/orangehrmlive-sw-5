package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.uitilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(name = "username")
    WebElement userNamefield;
    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordfield;
    @CacheLookup
    @FindBy(css = "button[type='submit']")
    WebElement loginBtn;
    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginPanelText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]//div[1]//span[1]")
    WebElement userNameFieldBlankErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement passwordFieldBlankErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidCredentialErrorMessage;

    public void setUserNamefield(String text) {
        sendTextToElement(userNamefield, text);
    }

    public void setPasswordfield(String text) {
        sendTextToElement(passwordfield, text);
    }

    public void clickOnLoginBtn() {
        clickOnElement(loginBtn);
    }

    public void loginToApplication(String username, String password) {
        setUserNamefield(username);
        setPasswordfield(password);
        clickOnLoginBtn();
    }
    public String getTheLoginPanelText() {
        return getTextFromElement(loginPanelText);
    }
    public String getUserNameFieldBlankErrorMessage() {
        return getTextFromElement(userNameFieldBlankErrorMessage);
    }

    public String getPasswordFieldBlankErrorMessage() {
        return getTextFromElement(passwordFieldBlankErrorMessage);
    }

    public String getInvalidCredentialErrorMessage() {
        return getTextFromElement(invalidCredentialErrorMessage);
    }

}
