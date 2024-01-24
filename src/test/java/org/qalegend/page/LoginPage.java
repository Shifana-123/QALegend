package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WaitUtility;
import org.qalegend.utilities.WebelementUtility;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passWordField;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButtonField;



    @FindBy(xpath = "//a[@class='btn btn-link']")
    WebElement forgotPassWordMenu;

    @FindBy(xpath="//button[@class='btn btn-default btn-sm']")
    WebElement endTourButtonField;

    @FindBy(xpath="//span[@class='help-block']//strong")
    WebElement errorMessageField;



    public String getPageTitle() {
        return driver.getTitle();
    }

    public ResetPage clickOnforgotPassWordMenu() {
        WebelementUtility.clickOnElement(forgotPassWordMenu);
        return new ResetPage(driver);
    }

    public void enterUserName(String username) {
        WebelementUtility.enterValue(userNameField, username);
    }

    public void enterPassWord(String password) {
        WebelementUtility.enterValue(passWordField, password);
    }

    public HomePage clickOnLoginButtonElement() {
        WebelementUtility.clickOnElement(loginButtonField);
        return new HomePage(driver);

    }
    public String getText() {
        String errorMessageText = WebelementUtility.getTextFromElement(errorMessageField);
        return errorMessageText;
    }
    public HomePage clickOnEndTourButton() {
        WebelementUtility.clickOnElement(endTourButtonField);
        return new HomePage(driver);
    }

    

    }



