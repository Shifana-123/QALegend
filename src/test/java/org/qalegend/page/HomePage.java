package org.qalegend.page;

import org.apache.commons.math3.analysis.function.HarmonicOscillator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.AppUtility;
import org.qalegend.utilities.WebDriverUtility;
import org.qalegend.utilities.WebelementUtility;

import java.util.List;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class='dropdown-toggle']//span[text()='admin KL']")
    WebElement userLoggedAccount;
    @FindBy(xpath = "/html/body/div[2]/header/nav/div/div/strong")
    WebElement loginDateElement;

    @FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/a/span[2]/i")
    WebElement userManagementOptionField;

    @FindBy(xpath = "/html/body/div[2]/aside/section/ul/li[2]/ul/li[1]/a/span")
    WebElement usersOptionField;


    public String getTitle() {
        return driver.getTitle();
    }
    public String getUserLoggedAccount() {
        String username = WebelementUtility.getTextFromElement(userLoggedAccount);
        return username;
    }
    public String getLoginDate() {
        String loginDate=WebelementUtility.getTextFromElement(loginDateElement);
        return loginDate;
    }
    public void clickOnUserManagement() {
        WebelementUtility.clickOnElement(userManagementOptionField);
    }
    public UsersPage clickOnUsersOption() {
        WebelementUtility.clickOnElement(usersOptionField);
        return new UsersPage(driver);
    }



    }






