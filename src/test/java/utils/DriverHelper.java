package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {
//This is code is Singleton Pattern
    private static WebDriver driver;

    private DriverHelper() {}

    // I make my constructor private, because I do want anyone to create an object
    //and manipulate my driver from this class.

    public static WebDriver getDriver(){
        if (driver==null|| ((RemoteWebDriver)driver).getSessionId() == null) {


            switch (ConfigReader.readProperty("QA_browser")) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--remote-allow-origins=*");
                        driver = new ChromeDriver(options); //<--- i can use these three lines of Code, only
                    //if I will have some issue with my Chrome, but if I do need to any issue, I will not put these lines
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    //we use Default if people will forget to provide anything
                     ChromeOptions options1 = new ChromeOptions();
                    options1.addArguments("--remote-allow-origins=*");
                     driver = new ChromeDriver(options1);   //<---I can use these three lines of Code, only
                    //if I will have some issue with my Chrome, but if I do need to any issue, I will not put these lines
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}




