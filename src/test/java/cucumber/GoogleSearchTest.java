package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/", plugin = {"pretty","html:out.html"}, tags = "@edit") //dodanie w pluginie .html spowodowało utworzenie pliku out.html, bez też byłoby ok
public class GoogleSearchTest {
}
