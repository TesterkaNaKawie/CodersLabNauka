package cucumber.hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelNewAddressPage {

    private final WebDriver driver;

    @FindBy(name = "address1")
    private WebElement addressInput;

    @FindBy(name = "postcode")
    private WebElement postalCodeInput;

    @FindBy(name = "city")
    private WebElement cityInput;

    @FindBy(name = "phone_mobile")
    private WebElement phoneNumberInput;

    @FindBy(name = "alias")
    private WebElement aliasInput;

    @FindBy(id = "submitAddress")
    private WebElement submitBtn;

    public HotelNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterNewAddressData(String alias, String address, String city, String postalCode, String phoneNumber) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);

        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);

        submitBtn.click();
    }
}
