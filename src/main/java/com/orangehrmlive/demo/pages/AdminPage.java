package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.uitilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUserText;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addBtn;


    public String getSystemUserText(){
        return getTextFromElement(systemUserText);
    }
    public void clickOnAddBtn(){
        clickOnElement(addBtn);
    }

//   public void setClickOnEmployeeName(){
//        clickOnElement(clickOnEmployeeName);
//   }
//   public void setSelectEmployeeName(){
//        clickOnElement(selectEmployeeName);
//   }

//    public List<String> getRecordOfUsers(){
//        return getList(recordOfUsers);
//   }


}
