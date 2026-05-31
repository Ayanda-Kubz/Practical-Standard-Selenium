package WEB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    WebElement usernameInp;
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordInp;
    @FindBy(xpath = "//*[@id=\"login-button\"]")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@class=\"error-message-container error\"]")
    WebElement errorMsg;


    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void sendUsername(String username){
        usernameInp.sendKeys(username);
    }

    public void sendPassword(String password){
        passwordInp.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public void getErrorMessage(){

        System.out.println(errorMsg.getText());
    }
}
