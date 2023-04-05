package selenium.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Przygotuj skrypt, który będzie przechodził pomiędzy kolejnymi stronami (nie klikamy żadnych elementów na tych stronach):
 https://coderslab.pl/pl
 https://mystore-testlab.coderslab.pl/index.php
 https://hotel-testlab.coderslab.pl/en/
 */
public class NavigationBetweenPages {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://coderslab.pl/pl");
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        driver.quit();
    }
}
