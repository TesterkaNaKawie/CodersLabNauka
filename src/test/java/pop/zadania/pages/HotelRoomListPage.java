package pop.zadania.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelRoomListPage {
    private final WebDriver driver;
    @FindBy(id = "hotel_cat_name")
    private WebElement searchHotelName;

    @FindBy(name = "check_in_time")
    private WebElement checkInSearchInput;

    @FindBy(name = "check_out_time")
    private WebElement checkOutSearchInput;

    @FindBy(className = "room_cont")
    private List<WebElement> roomsList;
    public HotelRoomListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getSearchHotelName() {
        return searchHotelName.getText();
    }

    public String getSearchedCheckInDate() {
        return checkInSearchInput.getAttribute("value");
    }
    public String getSearchedCheckOutDate() {
        return checkOutSearchInput.getAttribute("value");
    }
    public int roomsCount() {
        return roomsList.size();
    }

}
