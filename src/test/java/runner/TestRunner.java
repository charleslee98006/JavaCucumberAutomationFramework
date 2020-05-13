package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "json:target/cucumber/wikipedia.json",
                "html:target/cucumber/wikipedia.html",
                "pretty"
        },
        glue = {"stepDefinitions"},
        features = {"src/test/resources"},
        tags = {"@test"}
)
public class TestRunner {
}
