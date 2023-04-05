package selenium.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Przygotuj następującą sekwencję poruszania się po stronach z wykorzystaniem powyższych metod:
 *
 * Wejdź na stronę: https://www.google.com
 * Wejdź na stronę: https://coderslab.pl/pl
 * Cofnij się do strony: https://www.google.com
 * Wejdź na stronę: https://mystore-testlab.coderslab.pl/index.php
 * Cofnij się do strony: https://www.google.com
 * Powróć do strony: https://mystore-testlab.coderslab.pl/index.php
 * Odśwież stronę: https://mystore-testlab.coderslab.pl/index.php
 */
public class EnhanceNavigationBetweenPages {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        driver.get("https://coderslab.pl/pl");
        driver.navigate().back();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.navigate().back();//cofnij się do strony
        driver.navigate().forward();//powróć do stront
        driver.navigate().refresh();//odśwież stronę
        driver.quit();
    }
}
