package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage{
/**  Main pages isn't complete **/

    @FindBy(css =".btn-ra-menu-register")
    private WebElement registerBtn;


    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public RegistrationPage getRegisterPage(){
        clickElement(registerBtn);
        return new RegistrationPage(driver);
    }


}
