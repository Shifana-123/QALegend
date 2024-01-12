package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
    WebDriver driver;
    public UsersPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
