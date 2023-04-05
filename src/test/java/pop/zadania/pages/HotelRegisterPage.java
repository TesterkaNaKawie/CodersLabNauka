package pop.zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelRegisterPage {
    private final WebDriver driver;

    @FindBy(id="customer_firstname")
    private WebElement firstNameInput;
    @FindBy(id="customer_lastname")
    private WebElement lastNameInput;
    @FindBy(id="email")
    private WebElement emailInput;
    @FindBy(id="passwd")
    private WebElement passwordInput;
    @FindBy(id="submitAccount")
    private WebElement submitBtn;

    public HotelRegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getEmail() { //do asercji
        return emailInput.getAttribute("value"); //w value widnieje podany adres email przy zakładaniu konta!
    }

    public HotelMyAccountPage register() {
        submitBtn.click();
        return new HotelMyAccountPage(driver);
    }

    public void provideRequiredUserData(String firstName, String lastName, String password) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        passwordInput.clear();
        passwordInput.sendKeys(password);


    }
}
