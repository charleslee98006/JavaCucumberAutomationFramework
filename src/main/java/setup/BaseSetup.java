package setup;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSetup {

    private WebDriver webDriver;

    public BaseSetup(){
        setUpWebDriver();
    }

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
//        else if(("firefox").equalsIgnoreCase(browser)){
//
//        }
        else{
            try {
                throw new Exception("Currently only support Chrome and Firefox.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        webDriver.manage().window().maximize();
    }

    public WebDriver getWebDriver(){
        return this.webDriver;
    }
}
