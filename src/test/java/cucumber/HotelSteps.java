package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class HotelSteps {

    private WebDriver driver;

    @Given("I'm on hotel main page")
    public void openHotelMainPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2)); //czekanie żeby się stronka zdążyła załadować
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }

    @When("I sign in")
    public void iSignIn() {
        driver.findElement(By.className("user_login")).click();
    }

    @And("I enter email that is not already taken on authentication page")
    public void iEnterEmailThatIsNotAlreadyTakenOnAuthenticationPage() {
        String email = "ps" + System.currentTimeMillis() + "@test.com";
        driver.findElement(By.name("email_create")).sendKeys(email); //wykorzystujemy maila powyższego
        driver.findElement(By.id("SubmitCreate")).click(); //kliknie przycisk
    }

    @And("I enter name {string} surname {string} and password {string}")
    public void iEnterNameSurnameAndPassword(String name, String surname, String passwd) {
        driver.findElement(By.name("customer_firstname")).sendKeys(name);
        driver.findElement(By.id("customer_lastname")).sendKeys(surname);
        driver.findElement(By.name("passwd")).sendKeys(passwd);
        driver.findElement(By.id("submitAccount")).click();

    }

    @Then("I can see success message with test {string}") //"^I can see success message with text \"(.+)\"$"
    public void iCanSeeSuccessMessageWithTest(String text) {
        WebElement alert = driver.findElement(By.cssSelector(".alert.alert-success"));
        Assertions.assertTrue(alert.isDisplayed());
        Assertions.assertEquals(text, alert.getText());

    }

    @And("I close hotel browser")
    public void iCloseHotelBrowser() {
        driver.quit();
    }
}
