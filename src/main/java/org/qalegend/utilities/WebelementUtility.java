package org.qalegend.utilities;

import org.openqa.selenium.WebElement;

public class WebelementUtility {
    public static boolean isElementSelected(WebElement element) {
        boolean status= element.isSelected();
        return status;
    }
    public static void clickOnElement(WebElement element) {
        element.click();
    }
    public static void enterValue(WebElement element,String valuetoEnter){
        element.sendKeys(valuetoEnter);
    }
    public static String getTextFromElement(WebElement element) {
        String text=element.getText();
        return text;
    }
    public static boolean isElementDisplayed(WebElement element) {
        boolean elementstatus=element.isDisplayed();
        return elementstatus;
    }
    public static boolean isElementEnabled(WebElement element) {
        boolean status=element.isEnabled();
        return status;
    }
}

