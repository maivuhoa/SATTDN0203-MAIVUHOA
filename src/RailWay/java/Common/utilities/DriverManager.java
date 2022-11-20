package Common.utilities;

import Common.constant.Constant;
import DataObjects.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static ConfigFileReader configFileReader = new ConfigFileReader();

    public static void open() {
        setupDriver("chrome");
        Constant.WEBDRIVER.get(configFileReader.getApplicationUrl());
    }

    public static void setupDriver(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "chrome":
                Constant.WEBDRIVER = initChromeDriver();
                break;
            case "firefox":
                Constant.WEBDRIVER = initFirefoxDriver();
                break;
            default:
                System.out.println("Browser: " + browserType + " is invalid, Launching Chrome as browser of choice...");
                Constant.WEBDRIVER = initChromeDriver();
        }
    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        Constant.WEBDRIVER.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return Constant.WEBDRIVER;
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\Executables\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        Constant.WEBDRIVER = new FirefoxDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        Constant.WEBDRIVER.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return Constant.WEBDRIVER;
    }

    public static void afterTest() {
        Constant.WEBDRIVER.quit();
    }

}
