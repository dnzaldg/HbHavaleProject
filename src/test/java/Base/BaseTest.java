package Base;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {
    public String selectBrowser = "chrome";
    public WebDriver driver;
    public WebDriverWait wait;
    final static Logger logger = Logger.getLogger(BaseTest.class);

    @Before
    public void beforeMethod(){
        PropertyConfigurator.configure("log4j.properties");
        if (selectBrowser.equalsIgnoreCase("chrome")){
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--kiosk");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-fullscreen");
            System.setProperty("webdriver.chrome.driver","driver/chromedrive");
            driver=new ChromeDriver(options);
            wait=new WebDriverWait(driver,30);
            driver.get("https://www.hepsiburada.com");

        }else if (selectBrowser.equalsIgnoreCase("firefox")){
            FirefoxOptions options=new FirefoxOptions();
            options.addArguments("--kiosk");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-fullscreen");
            System.setProperty("webdriver.gecko.driver","driver/geckodriver");
            driver=new FirefoxDriver(options);
            wait=new WebDriverWait(driver,30);
            driver.get("https://www.hepsiburada.com");
        }
        else{
            Assert.fail("Driver bulunamadı.");
        }
    }

    @After
    public void afterMethod(){
        if (driver != null) {
            driver.quit();
        }
    }


}
