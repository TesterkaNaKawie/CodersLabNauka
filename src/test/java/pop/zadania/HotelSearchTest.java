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
import pop.zadania.pages.HotelRoomListPage;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelSearchTest {
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static WebDriver driver;

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
    public void searchAvailableRoomsInTheHotel() {
        HotelMainPage mainPage = new HotelMainPage(driver);
        HotelAuthPage authPage = mainPage.signInWithPage();

        HotelMyAccountPage myAccountPage = authPage.logInAs("psnauka@test.pl","12345");
        Assertions.assertFalse(authPage.isLoginErrorDisplayed(), "Login error shouldn't be displayed");

        mainPage = myAccountPage.goToHomePage();

        String selectedHotelName = mainPage.selectFirstHotel();

        String checkInDate = LocalDate.now().format(dateTimeFormatter);
        mainPage.enterCheckInDate(checkInDate);

        String checkOutDate = LocalDate.now().plusDays(1).format(dateTimeFormatter);
        mainPage.enterChockOutDate(checkOutDate);

        HotelRoomListPage roomListPage = mainPage.searchRooms();

        Assertions.assertTrue(roomListPage.roomsCount() > 0,"No rooms on tle list");
        Assertions.assertEquals(checkInDate, roomListPage.getSearchedCheckInDate(),"Different check in date");
        Assertions.assertEquals(checkOutDate,roomListPage.getSearchedCheckOutDate(),"Different check out date");
        Assertions.assertEquals(selectedHotelName,roomListPage.getSearchHotelName(),"Different Hotels");

    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
