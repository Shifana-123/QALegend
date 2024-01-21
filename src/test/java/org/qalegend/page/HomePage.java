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
    @FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']/strong[text()='21-01-2024']")
    WebElement loginDateElement;

    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    WebElement userManagementOptionField;



    @FindBy(xpath="//a[@class='dropdown-toggle']//span[text()='Shifana S']")
    WebElement newlyAddedUsersUserName;


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



    public String getCurrentDate() {
        String currentDate=DateUtility.getCurrentDateFormatted("dd-MM-yyyy");
        return currentDate;
    }
    public String getTextNewlyAddedUserName() {
        return WebelementUtility.getTextFromElement(newlyAddedUsersUserName);
    }
}










