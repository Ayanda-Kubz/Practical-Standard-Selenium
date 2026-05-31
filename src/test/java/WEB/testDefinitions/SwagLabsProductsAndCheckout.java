package WEB.testDefinitions;

import WEB.config.ConfigReader;
import WEB.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.nio.file.Path;
import java.time.Duration;
import java.util.Properties;

public class SwagLabsProductsAndCheckout {

//    declaration of driver and pages of website
    WebDriver driver;
    ConfigReader configReader;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    YourInfoPage yourInfoPage;
    YourCartPage yourCartPage;
    CheckoutOverviewPage checkoutOverview;
    Path folderPath;
    String testCaseNo;

//    Initialize and startup browser before running tests
    @Before
    public void setupBrowser() throws Exception{
        WebDriverManager.edgedriver().clearDriverCache().setup();
        driver = new EdgeDriver();
        configReader = new ConfigReader(driver);
        Properties config = configReader.readProperties();
        driver.get(config.getProperty("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        folderPath= configReader.createFolder();
    }

//    This for is for standard user following website

    @Given("User enters username {string} and password {string} and logs in for Test Case {string}")
    public void userLogsIn(String username, String password, String testCase){
        this.testCaseNo=testCase;
        loginPage = new LoginPage(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage.sendUsername(username);
        loginPage.sendPassword(password);
        loginPage.clickLoginBtn();
    }

    @When("User adds products to cart")
    public void addProductsToCart() throws InterruptedException, NoSuchElementException {
        inventoryPage = new InventoryPage(driver);

        inventoryPage.openBurgerMenu();
        //Implicit wait is not enough for burger menu to appear so Thread.sleep is used
        Thread.sleep(500);
        configReader.takeScreenshot("Burger Menu Options",folderPath,testCaseNo);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        inventoryPage.closeBurgerMenu();
        inventoryPage.addBackPackProductToCart();
        inventoryPage.addOnesieProductToCart();
        inventoryPage.addRedShirtProductToCart();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        inventoryPage.addBikeProductToCart();
        inventoryPage.addBoltShirtProductToCart();
        inventoryPage.addJacketProductToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        inventoryPage.goToCart();

    }
    @And("User checks outs selected items")
    public void checkoutProducts() throws NoSuchElementException{

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        yourCartPage = new YourCartPage(driver);
        yourCartPage.clickCheckoutBtn();
    }

    @And("User enters first name {string} last name {string} and zip code {string}")
    public void checkoutInputInfo(String firstName,String lastName, String zipCode) throws NoSuchElementException{

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        yourInfoPage = new YourInfoPage(driver);
        yourInfoPage.sendInformation(firstName,lastName,zipCode);
        configReader.takeScreenshot("Info",folderPath,testCaseNo);
        yourInfoPage.clickContinueCheckout();
    }

    @Then("User checks Product Price Totals and completes checkout")
    public void finishCheckoutPayment() throws NoSuchElementException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        checkoutOverview = new CheckoutOverviewPage(driver);

        System.out.println(checkoutOverview.getPaymentInfo());
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,150)", "");
        configReader.takeScreenshot("paymentInfo",folderPath,testCaseNo);
        checkoutOverview.clickFinishBtn();
        configReader.takeScreenshot("CompleteProcess",folderPath,testCaseNo);
        checkoutOverview.ThankYouComplete();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        configReader.takeScreenshot("BackHome",folderPath,testCaseNo);
    }

//    ****************************************************************************************

    // User cancels checkout payment and removes items from cart
    @Then("User checks Product Price Totals and cancels checkout")
    public void cancelCheckoutPayment() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        checkoutOverview = new CheckoutOverviewPage(driver);
        inventoryPage= new InventoryPage(driver);

        System.out.println(checkoutOverview.getPaymentInfo());
        checkoutOverview.clickCancelBtn();

        // Scroll up to the top of the page
        js.executeScript("window.scrollTo(0, 0);");
        configReader.takeScreenshot("Number of Items on Cart",folderPath,testCaseNo);

        inventoryPage.removeBackPackProductToCart();
        inventoryPage.removeBikeProductToCart();
        inventoryPage.removeBoltShirtProductToCart();
        inventoryPage.removeJacketProductToCart();
        inventoryPage.removeOnesieProductToCart();
        inventoryPage.removeRedShirtProductToCart();


        // Scroll up to the top of the page
        js.executeScript("window.scrollTo(0, 0);");

        configReader.takeScreenshot("Items on Cart after Removal",folderPath,testCaseNo);
    }
//    ****************************************************************************************

//  This flow is for Locked User

    @Given("Locked user enters username {string} and password {string} and logs in for Test Case {string}")
    public void lockedUserLogsIn(String username, String password,String testCase){
        this.testCaseNo=testCase;
        configReader.takeScreenshot("LockOutError",folderPath,testCaseNo);
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage.sendUsername(username);
        loginPage.sendPassword(password);
        loginPage.clickLoginBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        loginPage.getErrorMessage();
        configReader.takeScreenshot("LockErrorMsg",folderPath,testCaseNo);
    }
//    ****************************************************************************************


//  Flow to Filter the product
    @When("User selects to filter 1 by descending order by name {string}")
    public void filter1ProductsByPrice(String filterText){
        inventoryPage = new InventoryPage(driver);
        inventoryPage.clickFilterBtn(filterText);
        configReader.takeScreenshot(filterText,folderPath,testCaseNo);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @And("User selects to filter 2 by ascending order by name {string}")
    public void filter2ProductsByPrice(String filterText){
        inventoryPage = new InventoryPage(driver);
        inventoryPage.clickFilterBtn(filterText);
        configReader.takeScreenshot(filterText,folderPath,testCaseNo);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @And("User selects to filter 3 by ascending order by price {string}")
    public void filter3ProductsByPrice(String filterText){
        inventoryPage = new InventoryPage(driver);
        inventoryPage.clickFilterBtn(filterText);
        configReader.takeScreenshot(filterText,folderPath,testCaseNo);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @Then("User selects to filter 4 by descending order by price {string}")
    public void filter4ProductsByPrice(String filterText){
        inventoryPage = new InventoryPage(driver);
        inventoryPage.clickFilterBtn(filterText);
        configReader.takeScreenshot(filterText,folderPath,testCaseNo);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
//    ****************************************************************************************

//    Logout flow
    @Then("User Logs Out")
    public void useLogsOut(){

        inventoryPage = new InventoryPage(driver);
        inventoryPage.openBurgerMenu();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        inventoryPage.clickLogoutLink();
        configReader.takeScreenshot("Confirm Logout",folderPath,testCaseNo);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    // Close browser
    @After
    public void closeBrowser(){
        driver.quit();
    }
}
