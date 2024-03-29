package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.AppUtility;
import org.qalegend.utilities.WaitUtility;
import org.qalegend.utilities.WebelementUtility;

import java.util.List;

public class UsersPage {
    WebDriver driver;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
    WebElement addButtonField;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;
    @FindBy(xpath="//a[@class='dropdown-toggle']//span")
    WebElement usersLoggedUserName;

@FindBy(xpath="//table[@class='table table-bordered table-striped dataTable no-footer']//td[4]")
WebElement loggedUsersEmailID;



    @FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-default btn-flat']")
    WebElement signOutButton;



    public AddUsersPage clickOnAddButton() {
        WebelementUtility.clickOnElement(addButtonField);
        return new AddUsersPage(driver);
    }

    public void enterTextOnSearchField(String emailId) {
        if (searchField.isEnabled() && searchField.isDisplayed()) {
            searchField.click();
        } else {
            //System.out.println("Element is not clickable");
        }
        WebelementUtility.enterValue(searchField, emailId);
        WaitUtility.pageLoadWait(driver, 10);
    }

    public String getTextOfMailID() {
        String emailText=WebelementUtility.getTextFromElement(loggedUsersEmailID);
        return emailText;
    }
    public  void clickOnUsersLoggedUserName() {
        WebelementUtility.clickOnElement(usersLoggedUserName);
    }
    public LoginPage clickOnSignOutButton(){
        WebelementUtility.clickOnElement(signOutButton);
        return new LoginPage(driver);
    }
    public String getTextFromLoggedUsersMailID() {
        return WebelementUtility.getTextFromElement(loggedUsersEmailID);
    }
}


