package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.Objects;
@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }

    @Test(groups = {"smoke","sanity","regression"})
    public void verifyUserShouldLoginSuccessFully() {
        //Enter username
        // Enter password
        // Click on Login Button
        loginPage.loginToApplication("Admin", "admin123");
        // Verify "WelCome" Message
        String expectedDashboardWelcomeText = "Dashboard";
        String actualDashboardWelcomeText = dashboardPage.verifyTheWelcomeText();
        Assert.assertEquals(actualDashboardWelcomeText, expectedDashboardWelcomeText);
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        //Login To The application
        loginPage.loginToApplication("Admin", "admin123");
        // Verify Logo is Displayed
        Assert.assertTrue(dashboardPage.verifyHRForAllLogo(), "Logo is displayed");
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {
        //Login To The application
        loginPage.loginToApplication("Admin", "admin123");
        // Click on User Profile logo
        dashboardPage.clickOnUserProfileLogo();
        // Mouse hover on "Logout" and click
        dashboardPage.mouseHoverAndClickOnLogOut();
        // Verify the text "Login Panel" is displayed
        loginPage.getTheLoginPanelText();
    }

    @Test(dataProvider = "LoginCredentials", dataProviderClass = TestData.class,groups = "regression")
    public void verifyErrorMessageWithInvalidCredentials(String username,String password,String eMessage) {
        //Enter username <username>
        // Enter password <password>
        // Click on Login Button
        loginPage.loginToApplication(username, password);
        if(Objects.equals(username, password)){
            String actualMessage = loginPage.getUserNameFieldBlankErrorMessage();
            Assert.assertEquals(actualMessage, eMessage);
        } else if (Objects.equals(password, password)){
            String actualMessage = loginPage.getPasswordFieldBlankErrorMessage();
            Assert.assertEquals(actualMessage, eMessage);
        }else{
            String actualMessage = loginPage.getInvalidCredentialErrorMessage();
            Assert.assertEquals(actualMessage, eMessage);
        }
    }
}
