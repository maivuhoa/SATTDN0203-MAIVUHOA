package TestCases.login;

import Common.utilities.Utilities;
import DataObjects.Account;
import PageObjects.LoginPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUnSuccessWithInvalidPassword extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginUnSuccessWithInvalidPassword.class);

    @Test(description = "TC-03: User cannot log into Railway with invalid password ")
    public void testLoginFailWithInValidPassword() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginTab();
        logger.info("Step #2: Click on Login tab");
        loginPage.loginAccount(Account.USERNAME.getAccount(), Utilities.generateRandomStringWithSpecialCharacter(8));
        logger.info("Step #3: Login with valid Email and invalid Password");
        Assert.assertEquals(loginPage.getTextLblErrorMessageLogin(), "Invalid username or password. Please try again.");
    }
}
