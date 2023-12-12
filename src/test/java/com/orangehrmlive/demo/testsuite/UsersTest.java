package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.Random;

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {
    Random random = new Random();
    int num = random.nextInt();
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    AddUserPage addUserPage;

    ViewSystemUsersPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        adminPage = new AdminPage();
        addUserPage = new AddUserPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        //Login to Application
        loginPage.loginToApplication("Admin", "admin123");
        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();
        //Verify "System Users" Text
        String expectedSystemUserText = "System Users";
        String actualSystemUserText = adminPage.getSystemUserText();
        Assert.assertEquals(actualSystemUserText, expectedSystemUserText);
        //click On "Add" button
        adminPage.clickOnAddBtn();
        //Verify "Add User" Text
        String actualAddUserWelcomeText = addUserPage.getWelcomeText();
        String expectedAddUserWelcomeText = "Add User";
        Assert.assertEquals(actualAddUserWelcomeText, expectedAddUserWelcomeText);

        //Select User Role "Admin"
        //enter Employee Name "Ananya Dash"
        //enter Username
        //Select status "Disable"
        //enter psaaword
        //enter Confirm Password
        //click On "Save" Button
        addUserPage.addToUser("A", "Prime" + num, "Prime123", "Prime123");
        System.out.println("random = " + num);
        //verify message "Successfully Saved"
        String expectedSaveMsg = "Successfully Saved";
        String actualSaveMsg = addUserPage.getTextSuccessfullySaved();
        Assert.assertEquals(expectedSaveMsg, actualSaveMsg);

    }

    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
        //Login to Application
        loginPage.loginToApplication("Admin", "admin123");
        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();
        //Verify "System Users" Text
        String expectedSystemUserText = "System Users";
        String actualSystemUserText = adminPage.getSystemUserText();
        Assert.assertEquals(actualSystemUserText, expectedSystemUserText);
        //Enter Username
        viewSystemUsersPage.setEnterUsername("Prime" + num);
        //Select User Role
        viewSystemUsersPage.setOpenDropdownUserRole();
        viewSystemUsersPage.setSelectUserRole();
        //Select Status
        viewSystemUsersPage.clickOnStatus();
        viewSystemUsersPage.setSelectDisabledDropdown();
        //Click on "Search" Button
        viewSystemUsersPage.setClickOnSearchBtn();
        //Verify the User should be in Result list.
        String expectedUsername = "Prime" + num;
        String actualUsername = viewSystemUsersPage.getResultFromListUsername();
        Assert.assertEquals(expectedUsername, actualUsername);
        String expectedUserRole = "Admin";
        String actualUserRole = viewSystemUsersPage.getResultFromListUserRole();
        Assert.assertEquals(expectedUserRole, actualUserRole);
    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        //Login to Application
        loginPage.loginToApplication("Admin", "admin123");
        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();
        //Verify "System Users" Text
        String expectedSystemUserText = "System Users";
        String actualSystemUserText = adminPage.getSystemUserText();
        Assert.assertEquals(actualSystemUserText, expectedSystemUserText);
        //Enter Username
        viewSystemUsersPage.setEnterUsername("Prime" + num);
        //Select User Role
        viewSystemUsersPage.setOpenDropdownUserRole();
        viewSystemUsersPage.setSelectUserRole();
        //Select Status
        viewSystemUsersPage.clickOnStatus();
        viewSystemUsersPage.setSelectDisabledDropdown();
        //Click on "Search" Button
        viewSystemUsersPage.setClickOnSearchBtn();
        //Verify the User should be in Result list.
        String expectedUsername = "Prime" + num;
        String actualUsername = viewSystemUsersPage.getResultFromListUsername();
        Assert.assertEquals(expectedUsername, actualUsername);
        String expectedUserRole = "Admin";
        String actualUserRole = viewSystemUsersPage.getResultFromListUserRole();
        Assert.assertEquals(expectedUserRole, actualUserRole);
        //Click on Check box
        viewSystemUsersPage.setClickOnCheckbox();
        //Click on Delete Button
        viewSystemUsersPage.setClickOnDeleteBtn();
        //Popup will display
        //Click on Ok Button on Popup
        viewSystemUsersPage.setClickOnYesDelete();
        //verify message "Successfully Deleted"
        String expectedDeletedMsg = "Successfully Deleted";
        String actualDeletedMsg = viewSystemUsersPage.getTextDeletedMsg();
        Assert.assertEquals(expectedDeletedMsg, actualDeletedMsg);
    }

    @Test(dataProvider = "SystemUsers", dataProviderClass = TestData.class, groups = "regression")
    public void searchTheUserAndVerifyTheMessageRecordFound(String username, String userRole, String employeeName, String status) throws InterruptedException {
        //Login to Application
        loginPage.loginToApplication("Admin", "admin123");
        //click On "Admin" Tab
        dashboardPage.clickOnAdminTab();
        //Verify "System Users" Text
        String expectedSystemUserText = "System Users";
        String actualSystemUserText = adminPage.getSystemUserText();
        Assert.assertEquals(actualSystemUserText, expectedSystemUserText);
        //Enter Username
        viewSystemUsersPage.setEnterUsername(username);
        //Select User Role
        viewSystemUsersPage.setOpenDropdownUserRole();
        viewSystemUsersPage.setSelectUserRole(userRole);
        //Select Status
        viewSystemUsersPage.clickOnStatus();
        viewSystemUsersPage.setSelectstatusDropdown(status);
        //Enter EmployeeName <employeeName>
        viewSystemUsersPage.setEmployeeName(employeeName);
        //Click on "Search" Button
        viewSystemUsersPage.setClickOnSearchBtn();
        //verify message "(1) Record Found"
        String expectedRecord = "Record Found";
        String actualRecord = viewSystemUsersPage.getTextRecord();
        Assert.assertEquals(expectedRecord, actualRecord);
        //Verify username <username>
        String expectedUsername = "username";
        String actualUsername = viewSystemUsersPage.getTextUsername();
        Assert.assertEquals(expectedUsername, actualUsername);
        //Click on Reset Tab
        viewSystemUsersPage.setClickOnResetBtn();

    }
}
