package org.qalegend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
    WebDriver driver;
    public ResetPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
