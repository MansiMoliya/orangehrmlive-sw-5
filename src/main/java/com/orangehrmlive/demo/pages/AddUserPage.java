package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.uitilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[1]")
    WebElement dropdownUserRole;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Admin')]")
    WebElement selectAdminRole;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameField;

    @CacheLookup
    @FindBy(xpath = "//div[@role='listbox']//div[1]")
    WebElement selectEmployeeName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement enterUsername;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'-- Select --')]")
    WebElement openDropdownStatus;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Disabled']")
    WebElement selectDisabled;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement enterPassword;
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement enterConfirmPassword;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement clickOnSaveBtn;
    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement getTextSuccessfullySaved;

    public String getWelcomeText() {
        return getTextFromElement(welcomeText);
    }

    public void openDropdownForUsrRole() {
        clickOnElement(dropdownUserRole);
    }

    public void clickOnAdminRoleDropDown() {
        clickOnElement(selectAdminRole);
    }

    public void setEmployeeNameField(String text) {
        sendTextToElement(employeeNameField, text);
    }


    public void selectEmployeeName() throws InterruptedException {
        //Use Explicit Wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
//        WebElement textBox2Filed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//div[1]")));
        Thread.sleep(3000);
        clickOnElement(selectEmployeeName);
    }

    public void setUsername(String text) {
        sendTextToElement(enterUsername, text);
    }

    public void clickDropdownStatus() {
        clickOnElement(openDropdownStatus);
    }

    public void setSelectDisabled() {
        clickOnElement(selectDisabled);
    }

    public void setEnterPassword(String password) {
        sendTextToElement(enterPassword, password);
    }

    public void setConfirmPassword(String cPassword) {
        sendTextToElement(enterConfirmPassword, cPassword);
    }

    public void setClickOnSaveBtn() {
        clickOnElement(clickOnSaveBtn);
    }

    public String getTextSuccessfullySaved() {
        return getTextFromElement(getTextSuccessfullySaved);
    }
    public void explicitWait(int time) {
        waitUntilVisibilityOfElementLocated(By.className("ico-login"), time);
    }
//    public void addToUser(String name, String username, String password, String cPassword) throws InterruptedException {
//        openDropdownForUsrRole();
//        clickOnAdminRoleDropDown();
//        setEmployeeNameField(name);
//        selectEmployeeName();
//        setUsername(username);
//        clickDropdownStatus();
//        setSelectDisabled();
//        setEnterPassword(password);
//        setConfirmPassword(cPassword);
//        setClickOnSaveBtn();
//    }
}
