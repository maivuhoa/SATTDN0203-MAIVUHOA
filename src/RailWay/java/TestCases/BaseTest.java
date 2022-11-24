package TestCases;

import Common.utilities.DriverManager;
import Common.utilities.Utilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BaseTest {
    @BeforeTest
    public void setupBeforeTest() {
        Utilities.getLog();
    }

    @DataProvider(name = "Valid Email Length")
    public Object[][] validEmailLength() {
        return new Object[][]{{6}, {7}, {31}, {32}};
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
