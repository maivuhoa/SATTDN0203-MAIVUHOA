package Common.utilities;

import Common.constant.Constant;
import DataObjects.ConfigFileReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static final ConfigFileReader configFileReader = new ConfigFileReader();

    public static void open() {
        setupDriver(configFileReader.getBrowser());
        Constant.WEBDRIVER.get(configFileReader.getApplicationUrl());
    }

    public static void setupDriver(String browserType) {
        switch (browserType.trim().toLowerCase()) {
            case "firefox":
                initFirefoxDriver();
                break;
            default:
                initChromeDriver();
        }
    }

    private static void maximizeWindows() {
        Constant.WEBDRIVER.manage().window().maximize();
    }

    private static void pageLoadTimeout() {
        Constant.WEBDRIVER.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

    }

    private static void implicitlyWait() {
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void setupDriver() {
        maximizeWindows();
        pageLoadTimeout();
        implicitlyWait();
    }

    private static void initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        setupDriver();
    }

    private static void initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", Utilities.getProjectPath() + "\\Executables\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
        Constant.WEBDRIVER = new FirefoxDriver();
        setupDriver();
    }

    public static void quitDriver() {
        Constant.WEBDRIVER.quit();
    }

    public static void acceptAlert() {
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

}
