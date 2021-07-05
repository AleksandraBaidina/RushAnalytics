package Regression;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.MainPage;
import pageObjects.RegistrationPage;

public class RegistrationTests extends BaseTest{

    private RegistrationPage regPage;

    @BeforeEach
    public  void setUpBT()
    {
        driver = new ChromeDriver();
        driver.get(mainURL);
        MainPage mainPage = new MainPage(driver);

        /*** Creating Registration PageObject already have checked all web elements present ***/
        this.regPage =  mainPage.getRegisterPage();

    }

    @Test
    public void registrationPageUI()  {

        /** expected value should be get from JSON in future**/

        Assertions.assertEquals("User account | Rush Analytics",regPage.getTitle(),"Title isn't correct");
        Assertions.assertEquals("Регистрация",regPage.registerBtn.getText(),"Registration submenu title to SingUp isn't correct");
        Assertions.assertEquals("Войти",regPage.singInBtn.getText(),"Registration submenu title to SingIn isn't correct");
        Assertions.assertEquals("Google",regPage.googleSingIn.getText(),"SingIn Google has the wrong name");
        Assertions.assertEquals("Facebook",regPage.fbSingIn.getText(),"SingIn Facebook has the wrong name");

        Assertions.assertEquals("Введите ваш email*",regPage.emailInpt.getAttribute("placeholder"),"Email input has the wrong placeholder");

        /** Here will be others user interface assertions
         * .....
         * ....
         * **/

    }


    @Test
    public void singInByEmail() {

        var newUser = RegistrationPage.getRandomUser();
        regPage.singInByEmail(newUser);
        /** Check, that we has gone to registered page
         * in future, we have to do an additional testing: email, create password, SingIn for new User **/
        Assertions.assertEquals (mainURL.concat("/registered"),driver.getCurrentUrl());

    }

    @Test
    public void invalidInputTest() throws InterruptedException {
            /** Negative Input Test**/

        regPage.sendKeyEmailInpt("invalid");
        regPage.submitBtn.click();

        /** Check a error message is displayed**/
        Assertions.assertTrue(regPage.errorMsg.isDisplayed());
        /** Check border color is red **/
        Assertions.assertTrue(regPage.emailInpt.getCssValue("border").contains("rgb(255, 0, 0)"));

        /** Additional invalid value testing will be added here **/

    }

    @AfterEach
    public void tearDown()
    {
        driver.quit();

    }

}

