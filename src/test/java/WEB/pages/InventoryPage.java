package WEB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement burgerBtn;
    @FindBy(xpath="//*[@id=\"react-burger-cross-btn\"]")
    private WebElement closeBurgerMn;
    @FindBy(xpath = "//*[@id=\"about_sidebar_link\"]")
    private WebElement aboutLink;
    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement backpackPrd;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    private WebElement bikePrd;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]")
    private WebElement boltShirtPrd;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]")
    private WebElement jacketPrd;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    private WebElement onesiePrd;
    @FindBy(xpath = "//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
    private WebElement shirtRedPrd;

    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
    private WebElement removeBackpackPrd;
    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-bike-light\"]")
    private WebElement removeBikePrd;
    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-bolt-t-shirt\"]")
    private WebElement removeBoltShirtPrd;
    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-fleece-jacket\"]")
    private WebElement removeJacketPrd;
    @FindBy(xpath = "//*[@id=\"remove-sauce-labs-onesie\"]")
    private WebElement removeOnesiePrd;
    @FindBy(xpath = "//*[@id=\"remove-test.allthethings()-t-shirt-(red)\"]")
    private WebElement removeShirtRedPrd;

    @FindBy(xpath = "//*[@class=\"shopping_cart_link\"]")
    private WebElement cartBtn;

    @FindBy(xpath = "//*[@class=\"product_sort_container\"]")
    private WebElement filterBtn;


    public InventoryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void openBurgerMenu(){
        burgerBtn.click();
    }

    public void closeBurgerMenu(){
        closeBurgerMn.click();
    }

    public void clickAboutMenu(){
        aboutLink.click();
    }

    public void clickLogoutLink(){
        logoutLink.click();
    }

    public void addBackPackProductToCart(){
        backpackPrd.click();
    }

    public void addBikeProductToCart(){
        bikePrd.click();
    }

    public void addBoltShirtProductToCart(){

        boltShirtPrd.click();
    }
    public void addJacketProductToCart(){
        jacketPrd.click();
    }
    public void addOnesieProductToCart(){
        onesiePrd.click();
    }
    public void addRedShirtProductToCart(){
        shirtRedPrd.click();
    }

    public void removeBackPackProductToCart(){
        removeBackpackPrd.click();
    }
    public void removeBikeProductToCart(){
        removeBikePrd.click();
    }

    public void removeBoltShirtProductToCart(){

        removeBoltShirtPrd.click();
    }
    public void removeJacketProductToCart(){
        removeJacketPrd.click();
    }
    public void removeOnesieProductToCart(){
        removeOnesiePrd.click();
    }
    public void removeRedShirtProductToCart(){
        removeShirtRedPrd.click();
    }

    public void goToCart(){
        cartBtn.click();
    }

    public void clickFilterBtn(String webElementName){
        filterBtn.click();

        Select dropdown = new Select(filterBtn);
        dropdown.selectByVisibleText(webElementName);
    }
}
