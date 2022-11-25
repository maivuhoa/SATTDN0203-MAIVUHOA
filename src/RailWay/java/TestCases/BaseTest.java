package TestCases;

import Common.utilities.DriverManager;
import Common.utilities.Utilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    public void setupBeforeTest() {
        Utilities.getLog();
    }

    @BeforeMethod
    public void setup() {
        DriverManager.open();
    }

    @AfterMethod
    public void quit() {
        DriverManager.quitDriver();
    }
}
