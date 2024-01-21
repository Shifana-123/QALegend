package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WaitUtility;
import org.qalegend.utilities.WebelementUtility;

public class AddUsersPage {
    WebDriver driver;
    public  AddUsersPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="first_name")
    WebElement firstNameField;

    @FindBy(id="last_name")
    WebElement lastNameField;

    @FindBy(id="email")
    WebElement emailField;

    @FindBy(id="username")
    WebElement userNameField;

    @FindBy(id="password")
    WebElement passsWordField;

    @FindBy(id="confirm_password")
    WebElement confirmPassWordField;

    @FindBy(id="submit_user_button")
    WebElement saveButtonField;




    public String getTitle() {
        return driver.getTitle();
    }

    public void enterFirstName(String firstName){
        WebelementUtility.enterValue(firstNameField,firstName);
    }
    public void enterLastName(String lastName) {
        WebelementUtility.enterValue(lastNameField,lastName);
    }
    public void enterEmailId(String emailID) {
        WebelementUtility.enterValue(emailField,emailID);
    }
    public void enterUserName(String userName) {
        WebelementUtility.enterValue(userNameField,userName);
    }
    public void enterPassWord(String passWord) {
        WebelementUtility.enterValue(passsWordField,passWord);
    }
    public  void enterconfirmPassWord(String confirmPassword) {
        WebelementUtility.enterValue(confirmPassWordField,confirmPassword);
    }
    public UsersPage clickOnSaveButton() {
        WebelementUtility.clickOnElement(saveButtonField);
        WaitUtility.pageLoadWait(driver,10);
        driver.navigate().refresh();
        return new UsersPage(driver);

    }




}
