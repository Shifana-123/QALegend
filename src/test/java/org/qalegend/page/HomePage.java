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
    @FindBy(xpath = "//span[contains(text(),'User Management')]")
    WebElement userManagementOptionField;

    @FindBy(xpath="//li[@class='dropdown user user-menu']//span")
    WebElement userAccountName;

    @FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']//strong")
    WebElement userLoginDate;

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUserLoggedAccount() {
        String username = WebelementUtility.getTextFromElement(userAccountName);
        return username;
    }

    public String getLoginDate() {
        String loginDate = WebelementUtility.getTextFromElement(userLoginDate);
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

}










