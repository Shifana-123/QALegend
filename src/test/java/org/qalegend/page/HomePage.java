package org.qalegend.page;

import org.apache.commons.math3.analysis.function.HarmonicOscillator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.*;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle']//span[text()='admin KL']")
    WebElement userLoggedAccount;
    @FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']/strong[text()='19-01-2024']")
    WebElement loginDateElement;

    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    WebElement userManagementOptionField;

    @FindBy(xpath = "//span[@class='title' and contains(text(), 'Users')]")
    WebElement usersOptionField;


    @FindBy(xpath="//h1[contains(text(), 'Welcome Shifana')]")
    WebElement registeredUserNameText;


    public String getTitle() {
        return driver.getTitle();
    }

    public String getUserLoggedAccount() {
        String username = WebelementUtility.getTextFromElement(userLoggedAccount);
        return username;
    }

    public String getLoginDate() {
        String loginDate = WebelementUtility.getTextFromElement(loginDateElement);
        return loginDate;
    }

    public UserManagementPage clickOnUserManagement() {
        WebelementUtility.clickOnElement(userManagementOptionField);
        return new UserManagementPage(driver);
    }


    public UsersPage clickOnUsersOption() {
        if (usersOptionField.isDisplayed() && usersOptionField.isEnabled()) {
            WebelementUtility.clickOnElement(usersOptionField);
        }else  {
            // Handle the case where the element is not interactable
        }
        WaitUtility.pageLoadWait(driver,10);
        return new UsersPage(driver);

    }
    public String getCurrentDate() {
        String currentDate=DateUtility.getCurrentDateFormatted("dd-MM-yyyy");
        return currentDate;
    }
    public String getTextFromLoggedUserName() {
        return WebelementUtility.getTextFromElement(registeredUserNameText);
    }
}










