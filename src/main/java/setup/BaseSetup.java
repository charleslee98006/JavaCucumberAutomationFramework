package setup;

import io.restassured.RestAssured;
import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class sets up and configures selenium and rest assured for their respective tests.
 */
public class BaseSetup {

    private WebDriver webDriver;
    private Properties envProps;

    /**
     * This constructor calls on the configuration methods.
     */
    public BaseSetup(){
        readFromEnvironmentProperties();
        setUpWebDriver();
        setUpRestAssuredEndpoint();
    }

    /**
     * This method check and read the .properties file based on CLI argument.
     */
    public void readFromEnvironmentProperties() {
        try (InputStream input = new FileInputStream("src/test/resources/"+System.getProperty("env")+".properties")) {
            envProps = new Properties();
            envProps.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method pulls in from the environment.properties under resources and set up rest-assured configurations.
     */
    public void setUpRestAssuredEndpoint() {
            RestAssured.baseURI = envProps.getProperty("baseUrl");
            if(!envProps.getProperty("port").isEmpty()){
                RestAssured.port = Integer.parseInt(envProps.getProperty("port"));
            }
    }

    /**
     * This method sets up the webdrivers. Currently only supporting Chrome and Firefox for both windows and MacOS.
     */
    public void setUpWebDriver(){
        String browser = System.getProperty("browser");
        if(browser != null) {
            if (("chrome").equalsIgnoreCase(browser)) {
                if (OS.isFamilyWindows()) {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                } else {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
                }
                ChromeOptions options = new ChromeOptions();
                ChromeDriverService driverService = ChromeDriverService.createDefaultService();
                webDriver = new ChromeDriver(driverService, options);
            } else if (("firefox").equalsIgnoreCase(browser)) {
                if (OS.isFamilyWindows()) {
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                } else {
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
                }
                webDriver = new FirefoxDriver();
            } else {
                try {
                    throw new Exception("Currently only support Chrome and Firefox.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            webDriver.manage().window().maximize();
        }
    }

    /**
     * This method gets the configured webdriver.
     * @return Webdriver - the webdriver currently being used.
     */
    public WebDriver getWebDriver(){
        return this.webDriver;
    }
    /**
     * This method gets the configured webdriver.
     * @return Webdriver - the webdriver currently being used.
     */
    public String checkForParameterizedValues(String value){
        String patternString1 = "(\\{\\{.+?}})";
        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(value);

        while(matcher.find()) {
            System.out.println("found: " + matcher.group(1) +
                    " "       + matcher.group(2));
        }

        return value;
    }

}
