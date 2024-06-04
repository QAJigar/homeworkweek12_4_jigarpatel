package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    //this method click on element
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
    //this method get text from element
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
    //this method will send text to element
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    //selectByValueFromDropdown(By by, String value)
    public void selectByValueFromDropdown(By by, String value){
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select class
        Select select = new Select(dropDown);
        // Select by visible Text
        select.selectByValue(value);
    }
}
