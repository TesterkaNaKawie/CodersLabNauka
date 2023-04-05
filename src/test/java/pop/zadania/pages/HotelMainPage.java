package pop.zadania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelMainPage {
    private final WebDriver driver;

    @FindBy(name = "check_in_time")
    private WebElement checkInDateInput;

    @FindBy(name = "check_out_time")
    private WebElement checkOutDateInput;

    @FindBy(id = "search_room_submit")
    private WebElement searchRoomSubmitBtn;

    @FindBy(css = "button.header-rmsearch-input")
    private WebElement selectHotelBtn;
    @FindBy(css = ".hotel_dropdown_ul li")
    private List<WebElement> hotelDropdownList;

    public HotelMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void signIn() {
        driver.findElement(By.className("user_login")).click();
    }

    public HotelAuthPage signInWithPage() {
        signIn();
        return new HotelAuthPage(driver);
    }

    public void enterCheckInDate(String inDate) {
        checkInDateInput.clear();
        checkInDateInput.sendKeys(inDate);
    }
    public void enterChockOutDate(String outDate) {
        checkOutDateInput.clear();
        checkOutDateInput.sendKeys(outDate);
    }

    public HotelRoomListPage searchRooms() {
        searchRoomSubmitBtn.click();
        return new HotelRoomListPage(driver);
    }

    public String selectFirstHotel() {
        selectHotelBtn.click();
        WebElement hotel = hotelDropdownList.get(0);
        String hotelName = hotel.getText();
        hotel.click();
        return hotelName;
    }
}
