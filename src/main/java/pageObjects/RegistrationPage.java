package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class RegistrationPage extends BasePage{
    /**  Registration Page isn't complete. It's an example **/

    @FindBy(css =".page-user-tabs>a")
    public WebElement registerBtn;


    @FindBy(css =".page-user-tabs a:last-child")
    public WebElement singInBtn;


    @FindBy(css ="[class = 'btn btn-dark-red btn-ra-register-go w-100-percent m-bottom-11 f-size-16 f-weight-600']")
    public WebElement googleSingIn;


    @FindBy(css ="[class = 'btn btn-dark-blue btn-ra-register-fb w-100-percent m-bottom-11 f-size-16 f-weight-600']")
    public WebElement fbSingIn;

    @FindBy(css ="#edit-name")
    public WebElement emailInpt;


    @FindBy(css ="#edit-field-phone-und-0-value")
    public WebElement telInpt;


    @FindBy(css ="#edit-field-name-und-0-value")
    public WebElement nameInpt;


    @FindBy(css ="#edit-field-terms-und")
    public WebElement termChbx;


    @FindBy(css ="#edit-submit")
    public WebElement submitBtn;


    @FindBy(css ="#messages")
    public WebElement errorMsg;



    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle()
    {
        return driver.getTitle();
    }

    public void singInByEmail( HashMap<String, String> newUser)
    {
        sendKeyElement(emailInpt,newUser.get("email"));
        sendKeyElement(telInpt,newUser.get("tel"));
        sendKeyElement(nameInpt,newUser.get("name"));
        clickElement(termChbx);
        clickElement(submitBtn);
    }

    public static HashMap<String, String> getRandomUser()
    {
        HashMap<String, String> newUser = new HashMap<>();
        newUser.put("email",utils.Utils.RandEmail());
        newUser.put("tel",utils.Utils.RandomTelNumberRu());
        newUser.put("name",utils.Utils.RandString(10));
        return  newUser;
    }


    public void sendKeyEmailInpt(String key) {
        sendKeyElement(emailInpt,key);
    }
}
