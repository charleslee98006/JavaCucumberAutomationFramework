package stepDefinitions;

import io.cucumber.java.en.Given;
import setup.BaseSetup;

public class GUIStepDefs {
    private BaseSetup baseSetup;

    public GUIStepDefs(BaseSetup baseSetup){
        this.baseSetup = baseSetup;
    }

    @Given("I land on {string} page")
    public void i_land_on_page(String url){
    }
}
