package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearch {
    private WebDriver driver;

    @Given("an open browser with google.com")
    public void openGoogleSearch() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

    }

    @When("^a keyword (.*) is entered in input field$")
    public void enterKeyword(String keyword) {
        driver.findElement(By.id("L2AGLb")).click();
        WebElement element = driver.findElement(By.name("q"));
        element.clear();
        element.sendKeys(keyword);
        element.submit();}

    @Then("^the first one should contain (.*)$")
    public void theFirstOneShouldContainKeyword(String expectedText) {
        System.out.println(expectedText);
    }

    @And("close browser")
    public void closeBrowser() {
        driver.quit();
    }
}
