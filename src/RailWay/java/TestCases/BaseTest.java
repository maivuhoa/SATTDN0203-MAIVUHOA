package TestCases;

import Common.utilities.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseTest {
    @DataProvider(name = "Valid Email Length")
    public Object[][] validEmailLength() {
        return new Object[][]{{6}, {7}, {31}, {32}};
    }

    @BeforeMethod
    public void beforeTest() {
        DriverManager.open();
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.quitDriver();
    }
}
