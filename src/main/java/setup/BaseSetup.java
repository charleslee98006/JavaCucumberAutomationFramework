package setup;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class sets up and configures selenium and rest assured for their respective tests.
 */
public class BaseSetup {

    private WebDriver webDriver;

    /**
     * This constructor calls on the configuration methods.
     */
    public BaseSetup(){
        setUpWebDriver();
    }

    /**
     * This method sets up the webdrivers. Currently only supporting Chrome and Firefox for both windows and MacOS.
     */
    public void setUpWebDriver(){
        String browser = System.getProperty("browser");
        if(("chrome").equalsIgnoreCase(browser)){
            if(OS.isFamilyWindows()) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            }
            else{
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
            }
            ChromeOptions options = new ChromeOptions();
            ChromeDriverService driverService = ChromeDriverService.createDefaultService();
             webDriver = new ChromeDriver(driverService, options);
        }
        else if(("firefox").equalsIgnoreCase(browser)){
            if(OS.isFamilyWindows()) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            }
            else{
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
            }
            webDriver = new FirefoxDriver();
        }
        else{
            try {
                throw new Exception("Currently only support Chrome and Firefox.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        webDriver.manage().window().maximize();
    }
    /**
     * This method gets the configured webdriver.
     * @return Webdriver - the webdriver currently being used.
     */
    public WebDriver getWebDriver(){
        return this.webDriver;
    }
}
