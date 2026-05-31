package WEB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    private WebElement removeBackPackBtn;

    @FindBy(xpath = "//*[@id=\"continue-shopping\"]")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//*[@class=\"btn btn_action btn_medium checkout_button \"]")
    private WebElement checkoutBtn;

    public YourCartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void removeItemFromCard(){
        removeBackPackBtn.click();
    }

    public void clickContinueShopping(){
        continueShoppingBtn.click();
    }

    public void clickCheckoutBtn(){
        checkoutBtn.click();
    }

}
