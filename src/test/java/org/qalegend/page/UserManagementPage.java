package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qalegend.utilities.WebelementUtility;

public class UserManagementPage {
    WebDriver driver;
    public UserManagementPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

}
