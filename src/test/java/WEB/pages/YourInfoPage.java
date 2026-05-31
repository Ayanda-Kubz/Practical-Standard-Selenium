package WEB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourInfoPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"first-name\"]")
    private WebElement firstNameTxt;
    @FindBy(xpath = "//*[@id=\"last-name\"]")
    private WebElement lastNameTxt;
    @FindBy(xpath = "//*[@id=\"postal-code\"]")
    private WebElement zipCodeTxt;
    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement continueBtn;
    @FindBy(xpath = "//*[@id=\"cancel\"]")
    private WebElement cancelBtn;


    public YourInfoPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void sendInformation(String firstName,String lastName, String zipCode){


        firstNameTxt.sendKeys(firstName);
        lastNameTxt.sendKeys(lastName);
        zipCodeTxt.sendKeys(zipCode);

    }
    public void clickContinueCheckout(){
        continueBtn.click();
    }

    public void clickCancelCheckout(){
        cancelBtn.click();
    }


}
