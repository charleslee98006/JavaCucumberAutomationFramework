package stepDefinitions;

import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

/**
 * This class is a helper class that for repeating API actions.
 */
public class APIActions {

    public APIActions(){
    }

    /**
     * This method parses headers from input into rest-assured methods.
     * @return Request with the header
     */
    public RequestSpecification addHeaders(String headers){
        String[] headersArray = headers.split("\\,");
        for(String header : headersArray){
            String headerKey = header.split(":")[0];
            String headerValue = header.split(":")[1];
            given().header(headerKey,headerValue);
        }
        return given();
    }
}
