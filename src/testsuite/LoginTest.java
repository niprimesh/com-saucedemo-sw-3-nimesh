package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void openBrowser() throws InterruptedException {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        clickOnElement(By.name("login-button"));
        verifyText("did not matched","Products",getTextElement(By.xpath("//*[contains(@class,'title')]")));

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException{
        sendTextToElement(By.id("user-name"), "standard_user");
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        clickOnElement(By.name("login-button"));
        Thread.sleep(1000);
        //verify six products after login
        List<WebElement>products = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        int actual = products.size();
        int expected = 6;
        Assert.assertEquals(expected,actual);

    }
}
