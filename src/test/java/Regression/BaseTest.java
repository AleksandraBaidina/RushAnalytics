package Regression;

import com.google.common.annotations.VisibleForTesting;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected static WebDriver driver;
    protected static String mainURL;


    @BeforeAll
    public static void setUp() throws IOException {

		/** load properties **/
        var prop = new Properties();
        prop.load(new FileInputStream("config.properties"));


		/**create WebDriver base on properties Site (chrome or FireFox)
         * Recently, only Chrome is used**/
        String browser = prop.getProperty("browser");
        if (browser.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        }

        mainURL = prop.getProperty("URL");

    }


}
