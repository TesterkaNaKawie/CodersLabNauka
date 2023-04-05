package pop.zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelMyAccountPage {
    private final WebDriver driver;

    @FindBy(css = ".alert.alert-success")
    private WebElement successAlert;
    @FindBy(className = "account_user_name")
    private WebElement userName;
    @FindBy(css="a[title=Home]")
    private WebElement homeBtn;

    public HotelMyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessAlertDisplayed() {
        return successAlert.isDisplayed();
    }

    public String getSuccessMessage() {
        return successAlert.getText();
    }

    public String getUserName() {
        return userName.getText();
    }

    public HotelMainPage goToHomePage() {
        homeBtn.click();
        return new HotelMainPage(driver);
    }

}
