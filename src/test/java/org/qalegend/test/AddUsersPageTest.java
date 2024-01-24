package org.qalegend.test;
import org.qalegend.automationcore.Base;
import org.qalegend.constants.Constants;
import org.qalegend.constants.Messages;
import org.qalegend.page.*;
import org.qalegend.retryanalyzer.RetryAnalyzer;
import org.qalegend.utilities.ExcelUtility;
import org.qalegend.utilities.RandomUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;



public class AddUsersPageTest extends Base {
    @Test(groups="Sanity")
    public void verifyAddUserPageTitle() {
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String username = data.get(1);
        login.enterUserName(username);
        String password = data.get(2);
        login.enterPassWord(password);
        login.clickOnLoginButtonElement();
        HomePage home = login.clickOnEndTourButton();
        UserManagementPage usermanagement=home.clickOnUserManagement();
        UsersPage userPage =usermanagement.clickOnUsersOption();
        AddUsersPage addPage = userPage.clickOnAddButton();
        String actualUserPageTitle = addPage.getTitle();
        ArrayList<String> userPageData = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.ADD_USER_PAGE);
        String expectedUserPageTitle = userPageData.get(1);
        Assert.assertEquals(actualUserPageTitle, expectedUserPageTitle, Messages.TITLE_MISMATCH);
    }
    @Test(groups = "Smoke")
    public void verifyAddUser() {
        String firstName = RandomUtility.getFirstName();
        String lastName = RandomUtility.getLastName();
        String emailID = firstName + "." + lastName + "123@yahoo.com";
        String password = firstName + "." + lastName;
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String loginUsername = data.get(1);
        login.enterUserName(loginUsername);
        String loginPassword = data.get(2);
        login.enterPassWord(loginPassword);
        login.clickOnLoginButtonElement();
        HomePage home = login.clickOnEndTourButton();
        UserManagementPage userManagement=home.clickOnUserManagement();
        UsersPage userPage = userManagement.clickOnUsersOption();
        AddUsersPage adduser = userPage.clickOnAddButton();
        adduser.enterFirstName(firstName);
        adduser.enterLastName(lastName);
        adduser.enterEmailId(emailID);
        adduser.enterUserName(firstName);
        adduser.enterPassWord(password);
        adduser.enterconfirmPassWord(password);
        UsersPage users=adduser.clickOnSaveButton();
        users.enterTextOnSearchField(emailID);
        String actualLoggedEmailID=users.getTextFromLoggedUsersMailID();
        String expectedLoggedEmailID=emailID;
        Assert.assertEquals(actualLoggedEmailID,expectedLoggedEmailID,Messages.NEW_USER_ADDED_FAILED);

    }

    @Test(groups = "Smoke")
    public void verifyUserLoginWithNewlyAddedUser() {
        String firstName=RandomUtility.getFirstName();
        String lastName=RandomUtility.getLastName();
        String emailID=firstName + "." +lastName + "123@yahoo.com";
        String newPassWord=firstName + lastName + "123@";
        String newUserName=firstName + "newUser";
        LoginPage login = new LoginPage(driver);
        ArrayList<String> data = ExcelUtility.readData(Constants.TEST_DATA_EXCEL_PATH, Constants.LOGIN_PAGE);
        String loginUsername = data.get(1);
        login.enterUserName(loginUsername);
        String loginPassword = data.get(2);
        login.enterPassWord(loginPassword);
        login.clickOnLoginButtonElement();
        HomePage home=login.clickOnEndTourButton();
        UserManagementPage userManagement=home.clickOnUserManagement();
        UsersPage userPage = userManagement.clickOnUsersOption();
        AddUsersPage adduser = userPage.clickOnAddButton();
        adduser.enterFirstName(firstName);
        adduser.enterLastName(lastName);
        adduser.enterEmailId(emailID);
        adduser.enterUserName(newUserName);
        adduser.enterPassWord(newPassWord);
        adduser.enterconfirmPassWord(newPassWord);
        UsersPage usersPage=adduser.clickOnSaveButton();
        usersPage.clickOnUsersLoggedUserName();
        LoginPage loginPage=usersPage.clickOnSignOutButton();
        loginPage.enterUserName(newUserName);
        loginPage.enterPassWord(newPassWord);
        HomePage homePage=login.clickOnLoginButtonElement();
        String actualTextOfAddedUser=homePage.getUserLoggedAccount();
        Assert.assertEquals(actualTextOfAddedUser,newUserName,Messages.NEW_USER_ADDED_FAILED);
    }
}
