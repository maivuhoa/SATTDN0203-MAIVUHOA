package TestCases.login;

import Common.utilities.Utilities;
import PageObjects.LoginPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUnSuccessWithInvalidAccount extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginUnSuccessWithBlankUserName.class);

    @Test(description = "TC-08: User can't login with an account hasn't been registered")
    public void testLoginFailWithInvalidAccount() {
        String email = Utilities.generateRandomEmail(8);
        String password = Utilities.generateRandomString(8);
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        logger.info("Step #2: Click on Login tab");
        loginPage.clickLoginTab();
        logger.info("Step #3: User enter an account which is not registered");
        logger.info("Step #4: Click on Login button");
        loginPage.loginAccount(email, password);
        Assert.assertEquals(loginPage.getTextLblErrorMessageLogin(), "Invalid username or password. Please try again.");
    }
}
