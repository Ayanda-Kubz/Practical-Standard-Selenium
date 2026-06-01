package WEB.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\test\\resources\\features",
        glue = "WEB.testDefinitions",
//        tags = "@NegativeTests",
        monochrome = true,
        plugin = "html:Results\\report.html"
)
public class TestSwagLabsRunner {
}