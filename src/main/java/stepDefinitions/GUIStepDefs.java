package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseSetup;
import static org.junit.Assert.*;

public class GUIStepDefs {
    private BaseSetup baseSetup;
    private WebDriver webDriver;
    private GUIActions guiAction;
    private WebDriverWait wait;

    public GUIStepDefs(BaseSetup baseSetup){
        this.baseSetup = baseSetup;
        this.webDriver = baseSetup.getWebDriver();
        this.wait = new WebDriverWait(webDriver, 15, 1000);

        this.guiAction = new GUIActions();
    }

    @Given("I land on {string} page")
    public void i_land_on_page(String url){
        webDriver.get(url);
    }

    @When("I type {string} in the input field element {string}")
    public void i_type_into_input_field(String searchInput, String element){
        wait.until(ExpectedConditions.presenceOfElementLocated(guiAction.getElement(element))).sendKeys(searchInput);
    }

    @When("I click on button element {string}")
    public void i_click_element(String element){
        wait.until(ExpectedConditions.elementToBeClickable(guiAction.getElement(element))).click();
    }

    @Then("I expect to see element {string}")
    public void i_expect_to_see_element(String element){
        assertTrue("Element is not displayed on the browser",
                wait.until(ExpectedConditions.visibilityOfElementLocated(guiAction.getElement(element))).isDisplayed());
    }
}
