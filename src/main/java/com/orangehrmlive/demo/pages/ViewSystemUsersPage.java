package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.uitilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ViewSystemUsersPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement enterUsername;
    @CacheLookup
    @FindBy(xpath = "(//div)[38]")
    WebElement openDropdownUserRole;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Admin')]")
    WebElement selectUserRole;
    @CacheLookup
    @FindBy(xpath = "(//i[@class='oxd-icon bi-check oxd-checkbox-input-icon'])[2]")
    WebElement clickOnCheckbox;
//    @CacheLookup
//    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
//    WebElement clickOnEmployeeName;
//    @CacheLookup
//    @FindBy(xpath = "//div[@role='listbox']//div[1]")
//    WebElement selectEmployeeName;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
    WebElement openDropDownStatus1;
    @CacheLookup
    @FindBy(xpath = "(//div[@role='option'])[3]")
    WebElement selectStatus;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement clickOnSearchBtn;
    @CacheLookup
    @FindBy(xpath = "(//div[@data-v-6c07a142])[1]")
    WebElement getResultFromListUsername;
    @CacheLookup
    @FindBy(xpath = "(//div[@role='cell'])[3]")
    WebElement getResultFromListUserRole;
    @CacheLookup
    @FindBy(xpath = "//div[@role='listbox']//div[1]")
    WebElement selectEmployeeName;
    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-container']//button[1]")
    WebElement clickOnDeleteBtn;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement clickOnYesDelete;
    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement getTextDeletedMsg;
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(64) Records Found']")
    WebElement recordOfUsers;
    @CacheLookup
    @FindBy(xpath ="(//div[@role='cell'])[2]")
    WebElement getUserName;
    @CacheLookup
    @FindBy(className = "oxd-button oxd-button--medium oxd-button--ghost")
    WebElement clickOnResetBtn;
    public void setEnterUsername(String username){
        sendTextToElement(enterUsername,username);
    }
    public void setOpenDropdownUserRole(){
        clickOnElement(openDropdownUserRole);
    }
    public void setSelectUserRole(){
        clickOnElement(selectUserRole);
    }
    public void setSelectUserRole(String userRole){
        clickOnElement(selectUserRole);
    }
    public void clickOnStatus(){
        clickOnElement(openDropDownStatus1);
    }
    public void setSelectstatusDropdown(String status){
        clickOnElement(selectStatus);
    }
    public void setSelectDisabledDropdown(){
        clickOnElement(selectStatus);
    }
    public void setEmployeeName(String employeeName){
        sendTextToElement(selectEmployeeName,employeeName);
    }
    public void setClickOnSearchBtn() {
        clickOnElement(clickOnSearchBtn);
    }
    public String getResultFromListUsername(){
        return getTextFromElement(getResultFromListUsername);
    }
    public String getResultFromListUserRole(){
        return getTextFromElement(getResultFromListUserRole);
    }
    public void setClickOnCheckbox(){
        clickOnElement(clickOnCheckbox);
    }
    public void setClickOnDeleteBtn(){
        clickOnElement(clickOnDeleteBtn);
    }
    public void setClickOnYesDelete(){
        clickOnElement(clickOnYesDelete);
    }
    public String getTextDeletedMsg(){
        return getTextFromElement(getTextDeletedMsg);
    }
    public String getTextRecord(){
        return getTextFromElement(recordOfUsers);
    }
    public String getTextUsername(){
        return getTextFromElement(getUserName);
    }
    public void setClickOnResetBtn(){
        clickOnElement(clickOnResetBtn);
    }
}
