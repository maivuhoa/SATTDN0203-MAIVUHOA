package TestCases;

import Common.Common.Utilities;
import Common.Constant.CONSTANT;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class SetUp {
    @DataProvider(name = "Valid Email Length")
    public Object[][] ValidEmaillength() {
        return new Object [][] {{6},{7}, {31},{32}};
    }
    @DataProvider(name = "InValid Email Length")
    public Object[][] InvalidEmaillength() {
        return new Object [][] {{5},{4}, {33},{34}};
    }
    @BeforeTest
    public void setup(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        CONSTANT.WEBDRIVER =new ChromeDriver();
        CONSTANT.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CONSTANT.WEBDRIVER.get(CONSTANT.RailwayURL);
    }

    @AfterTest
    public void afterClass() {
        CONSTANT.WEBDRIVER.quit();
    }
}
