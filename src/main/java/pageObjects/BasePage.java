package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    protected WebDriver driver;

    protected void clickElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 1000);

        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    protected void sendKeyElement(WebElement element,String key)
    {
        WebDriverWait wait = new WebDriverWait(driver, 1000);

        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(key);

    }


}
