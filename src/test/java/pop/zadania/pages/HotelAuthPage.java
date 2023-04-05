package pop.zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelAuthPage {
    private final WebDriver driver;
    @FindBy(id="email_create")
    private WebElement newUserEmailInput;
    @FindBy(id="SubmitCreate")
    private WebElement createNewAccountBtn;
    @FindBy(id="email")
    private WebElement loginEmailInput;
    @FindBy(id="passwd")
    private WebElement passwordInput;
    @FindBy(id="SubmitLogin")
    private WebElement loginBtn;

    @FindBy(css = ".alert-danger li")
    private List<WebElement> loginErrors;

    public HotelAuthPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //do inicjowania WebElement'ów zlokalizowanych przez annotacje @FindBy
    }

    public HotelRegisterPage enterNewUserEmailSubmit(String email){
        newUserEmailInput.clear();
        newUserEmailInput.sendKeys(email);
        createNewAccountBtn.click();
        return new HotelRegisterPage(driver);
    }

    public HotelMyAccountPage logInAs(String email,String password) {
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();
        return new HotelMyAccountPage(driver);
    }
    public boolean isLoginErrorDisplayed() {
        return !loginErrors.isEmpty();
    }
}
