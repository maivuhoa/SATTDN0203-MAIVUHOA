package TestCases;

import Common.utilities.DriverManager;
import Common.utilities.Utilities;
import Common.constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class SetUpBaseTest {
    @DataProvider(name = "Valid Email Length")
    public Object[][] ValidEmaillength() {
        return new Object[][]{{6}, {7}, {31}, {32}};
    }

    @DataProvider(name = "InValid Email Length")
    public Object[][] InvalidEmaillength() {
        return new Object[][]{{5}, {4}, {33}, {34}};
    }

    @BeforeMethod
    public void beforeTest() {
        DriverManager.open();
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.afterTest();
    }
}