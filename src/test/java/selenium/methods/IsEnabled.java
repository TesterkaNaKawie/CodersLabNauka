package selenium.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IsEnabled {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://pl.wikipedia.org/");
        WebElement search = driver.findElement(By.id("searchInput")); //webelement search wyszukany po id
        /*sprawdzamy czy element search jest aktywny*/
        if(search.isEnabled()) {
            search.sendKeys("selenium");//jeśli aktywny wyszukujemy selenium
            search.submit();//zatwierdzamy fomularz/enter
        }else 	{
            System.out.println("Element not enabled");//jeśli jest nieaktywny wyświetlamy komunikat
        }
        driver.quit();
    }
}
