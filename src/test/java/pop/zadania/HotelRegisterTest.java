package pop.zadania;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pop.zadania.pages.HotelAuthPage;
import pop.zadania.pages.HotelMainPage;
import pop.zadania.pages.HotelMyAccountPage;
import pop.zadania.pages.HotelRegisterPage;

import java.time.Duration;

public class HotelRegisterTest {
    public static WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://hotel-testlab.coderslab.pl/en/");
    }
    @Test
    public void testNewUserRegistration() {
        HotelMainPage mainPage = new HotelMainPage(driver);
/*      mainPage.signIn();

        HotelAuthPage authPage = new HotelAuthPage(driver);*/
        HotelAuthPage authPage = mainPage.signInWithPage();
/*      authPage.enterNewUserEmailSubmit("ps@test.pl");

        HotelRegisterPage registerPage = new HotelRegisterPage(driver);*/
        //HotelRegisterPage registerPage = authPage.enterNewUserEmailSubmit("ps@test.pl");
        //HotelRegisterPage registerPage = authPage.enterNewUserEmailSubmit(generateUniqueEmail());
        String uniqueEmail = generateUniqueEmail();//wyciągnięcie do asercji
        HotelRegisterPage registerPage = authPage.enterNewUserEmailSubmit(uniqueEmail);

        String firstName = "Patrycja";
        registerPage.provideRequiredUserData(firstName, "Stasz","superpass");
        Assertions.assertEquals(uniqueEmail,registerPage.getEmail(), "Different email addresses"); //ASERCJA czy email zgadza się z tym podanym podczas rejestracji

        HotelMyAccountPage myAccountPage = registerPage.register();
        Assertions.assertTrue(myAccountPage.isSuccessAlertDisplayed(),"Success Alert wasn't displayed");
        Assertions.assertEquals("Your account has been created.", myAccountPage.getSuccessMessage(),"Not the same success alert message");
        Assertions.assertEquals(firstName, myAccountPage.getUserName(),"Not the same username");
    }
    private String generateUniqueEmail() {
        return "ps" + System.currentTimeMillis() + "@test.com";
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
