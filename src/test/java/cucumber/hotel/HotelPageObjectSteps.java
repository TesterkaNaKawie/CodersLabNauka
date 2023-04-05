package cucumber.hotel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HotelPageObjectSteps {
    WebDriver driver;
    HotelMyAddressesPage myAddressesPage;

    @Given("I'm on the hotel main page")
    public void openHotelMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("I go to login page")
    public void iGoToLoginPage() {
        HotelMainPage mainPage = new HotelMainPage(driver);
        mainPage.signIn();
    }

    @And("I login using {string} and {string}")
    public void iLoginUsingAnd(String email, String password) {
        HotelAuthPage authPage = new HotelAuthPage(driver);
        authPage.loginAs(email, password);
    }

    @And("I go to my addresses page")
    public void iGoToMyAddressesPage() {
        HotelMyAccountPage myAccountPage = new HotelMyAccountPage(driver);
        myAccountPage.goToMyAddressesPage();
    }

    @And("I can see there is no addresses")
    public void iCanSeeThereIsNoAddresses() {
        myAddressesPage = new HotelMyAddressesPage(driver);
        Assertions.assertFalse(myAddressesPage.addressIsVisible(), "There should be no addresses");
    }

    @And("I add new address")
    public void iAddNewAddress() {
        myAddressesPage.addNewAddress();
    }

    @And("I enter new address {string}, {string}, {string}, {string}, {string}")
    public void iEnterNewAddress(String alias, String address, String postalCode, String city, String phoneNumber) {
        HotelNewAddressPage newAddressPage = new HotelNewAddressPage(driver);
        newAddressPage.enterNewAddressData(alias, address, city, postalCode, phoneNumber);
    }

    @Then("I can see new address")
    public void iCanSeeNewAddress() {
        Assertions.assertTrue(myAddressesPage.addressIsVisible(), "There should be one address on the list");
    }

    @And("I close the browser")
    public void iCloseTheBrowser() {
        driver.quit();
    }

    @And("I verify created address {string}, {string}, {string}, {string}, {string}")
    public void iVerifyCreatedAddress(String alias, String address, String postalCode, String city, String phoneNumber) {
        String addressAsText = myAddressesPage.getFirstAddressAsText();
        String expectedAddress = String.join("\n", alias.toUpperCase(), address, postalCode + " " + city, phoneNumber);
        Assertions.assertEquals(expectedAddress, addressAsText);
    }

    @And("I remove the address")
    public void iRemoveTheAddress() {
        myAddressesPage.removeTheAddress();
    }

    @And("I can see the address was removed")
    public void iCanSeeTheAddressWasRemoved() {
        Assertions.assertFalse(myAddressesPage.addressIsVisible());
    }
}