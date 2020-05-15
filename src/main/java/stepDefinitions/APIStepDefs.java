package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import setup.BaseSetup;

/**
 * This class is the step definition for API test cases.
 */
public class APIStepDefs {

    private String url;
    private RequestSpecification request;
    private APIActions apiActions;
    private Response response;

    /**
     * This constructor uses Cucumber Dependency injection to instantiate a single BaseSetup class that can be shared.
     */
    public APIStepDefs(BaseSetup baseSetup){
        this.apiActions = new APIActions();
    }

    /**
     * This method take in the API url and header.
     */
    @Given("I have an url {string} and header(s) {string}")
    public void i_have_url_header(String url, String headers){
        this.url = url;
        request = apiActions.addHeaders(headers);
    }

    /**
     * This method take in the API url, header and body.
     */
    @Given("I have an url {string}, header {string} and body {string}")
    public void i_have_url_header_body(String url, String header, String body){
    }

    /**
     * This method is to take different REST request and makes the calls.
     */
    @When("I make {string} REST call")
    public void i_make_rest_call(String httpRequestMethod){
        if(("GET").equalsIgnoreCase(httpRequestMethod)){
            this.response = request.when().get(this.url);
        }
        else if(("PUT").equalsIgnoreCase(httpRequestMethod)){
            this.response = request.when().put(this.url);
        }
        else if(("POST").equalsIgnoreCase(httpRequestMethod)){
            this.response = request.when().post(this.url);
        }
        else if(("DELETE").equalsIgnoreCase(httpRequestMethod)){
            this.response = request.when().delete(this.url);
        }
    }

    /**
     * This method validates if the status code matches user expected input
     */
    @Then("I expect to see {string} status code")
    public void i_expect_(String expectedStatusCode){
        Assert.assertEquals(Integer.parseInt(expectedStatusCode),this.response.getStatusCode());
    }
}
