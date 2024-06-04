package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;
import java.util.Locale;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    //1. userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //* Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //* Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //* Verify the text “PRODUCTS”
        Assert.assertEquals("Text Not Found","PRODUCTS", driver.findElement(By.className("title")).getText().toUpperCase(Locale.ROOT));
    }

    @Test
    //2. verifyThatSixProductsAreDisplayedOnPage
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //* Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //* Enter “secret_sauce” password
        sendTextToElement(By.id("password"), "secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //* Verify that six products are displayed on page
        Assert.assertEquals("Product List Are Displayed", 6,  driver.findElements(By.xpath("//div[@class=\"inventory_item\"]")).size());
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
