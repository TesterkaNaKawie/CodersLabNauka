package selenium.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Wykorzystując kod z zajęć, przygotuj test, który wyszuka inną frazę w wyszukiwarce Google.
 */
public class GoogleSearch {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");//ustawienie parametrów sterownika przeglądarki
        ChromeOptions options = new ChromeOptions(); //driver działający na wszystkich wersjach
        options.addArguments("--remote-allow-origins=*"); //driver działający na wszystkich wersjach
        WebDriver driver = new ChromeDriver(options);//uruchomienie przeglądarki chrome; driver działający na wszystkich wersjach
        //WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();//maksymalizacja okna z wykorzystaniem metod interfejsów ChromeDriver
        driver.get("http://www.google.com");//otworzenie strony
        driver.findElement(By.id("L2AGLb")).click();//znalezienie elementu po id + kliknięcie {zgody na ciasteczka itp.}
        WebElement element = driver.findElement(By.name("q"));//interfejs WebElement{symulacja klawiatury i kliknięć przycisków} + znalezienie po nazwie pola wyszukiwarki google
        element.clear();//wyczyszczenie wcześniejszych wartości {tylko pola i obszary tekstowe}
        element.sendKeys("coś");//pisanie w elemencie {dowolny element}
        element.submit();//zatwierdzenie formularza{często wykorzystywana zamiast Enter}
        driver.quit();//zamknięcie przeglądarki
    }
}
