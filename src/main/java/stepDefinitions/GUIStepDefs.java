package stepDefinitions;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import setup.BaseSetup;

public class GUIStepDefs {
    private BaseSetup baseSetup;
    private WebDriver webDriver;

    public GUIStepDefs(BaseSetup baseSetup){
        this.baseSetup = baseSetup;
        webDriver = baseSetup.getWebDriver();

    }

    @Given("I land on {string} page")
    public void i_land_on_page(String url){

    }
}
