package pop.slajdy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pop.slajdy.page.LoginPage;

import java.time.Duration;

public class LoginTest {

    public static WebDriver driver; //statyczne pole WebDriver żeby móc przekazać do klasy LoginPage; odwoływanie się do jednej instacji drivera

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
    }
    @Test
    public void testLoginWithProperCredentials() {

        LoginPage loginPage = new LoginPage(driver);//utworzenie nowego PageObject
        loginPage.loginAs("michal.dobrzycki@coderslab.pl", "CodersLab");//wywołanie na PageObject metody loginAs()
        Assertions.assertEquals("Automated Tester", loginPage.getLoggedUsername());//wywołanie na PageObject metody getLoggedUsername i sprawdzeniu czy zwraca nam tekst “Automated Tester”.
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
