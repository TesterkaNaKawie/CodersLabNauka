package cucumber.hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelMyAddressesPage {

    private final WebDriver driver;

    @FindBy(css = "a[title='Add an address']")
    private WebElement newAddressBtn;

    @FindBy(css = "div.address")
    private List<WebElement> addresses;

    public HotelMyAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addNewAddress() {
        newAddressBtn.click();
    }

    public boolean addressIsVisible() {
        return addresses.size() > 0;
    }

    public String getFirstAddressAsText() {
        WebElement address = addresses.get(0);
        String alias = address.findElement(By.className("page-subheading")).getText();
        String addressText = address.findElement(By.className("address_address1")).getText();
        String cityAndPostal = address.findElement(By.xpath("//*[@class='address_city']/..")).getText();
        String phone = address.findElement(By.className("address_phone_mobile")).getText();
        return String.join("\n", alias, addressText, cityAndPostal, phone);
    }

    public void removeTheAddress() {
        for (WebElement address : addresses) {
            address.findElement(By.cssSelector("a[title='Delete']")).click();
            driver.switchTo().alert().accept();
        }
    }
}
