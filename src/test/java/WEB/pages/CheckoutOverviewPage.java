package WEB.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@data-test=\"payment-info-value\"]")
    private WebElement paymentInfoTxt;
    @FindBy(xpath = "//*[@data-test=\"shipping-info-value\"]")
    private WebElement shippingInfo;
    @FindBy(xpath = "//*[@data-test=\"subtotal-label\"]")
    private WebElement itemTotalTxt;
    @FindBy(xpath = "//*[@data-test=\"tax-label\"]")
    private WebElement totalTaxTxt;
    @FindBy(xpath = "//*[@data-test=\"total-label\"]")
    private WebElement totalAmountTxt;

    @FindBy(xpath = "//*[@id=\"finish\"]")
    private WebElement finishBtn;

    @FindBy(xpath = "//*[@id=\"cancel\"]")
    private WebElement cancelBtn;

    @FindBy(xpath = "//*[@id=\"back-to-products\"]")
    private WebElement backHomeBtn;

    public CheckoutOverviewPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getPaymentInfo(){

        return paymentInfoTxt.getText() +"\n" + shippingInfo.getText() +"\n" +itemTotalTxt.getText() +"\n"
                + totalTaxTxt.getText() +"\n" + totalAmountTxt.getText();
    }
    public void clickFinishBtn(){
        finishBtn.click();
    }
    public void clickCancelBtn(){
        cancelBtn.click();
    }
    public void ThankYouComplete(){
        backHomeBtn.click();
    }
}
