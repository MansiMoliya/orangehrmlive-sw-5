package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.uitilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utility {
    @CacheLookup
    @FindBy(css = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")
    WebElement adminTab;
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Dashboard']")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(className = "oxd-userdropdown-tab")
    WebElement userProfileLogo;
    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement clickOnLogout;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-brand-banner']")
    WebElement HRForAllLogo;
    public String verifyTheWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public void clickOnAdminTab() {
        clickOnElement(adminTab);
    }
    public void clickOnUserProfileLogo(){
        clickOnElement(userProfileLogo);
    }
    public void mouseHoverAndClickOnLogOut() {
        mouseHoverToElementAndClick(clickOnLogout);
    }
    public Boolean verifyHRForAllLogo() {
        return (HRForAllLogo).isDisplayed();
    }
}
