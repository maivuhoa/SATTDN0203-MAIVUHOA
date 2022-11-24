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
        LoginPage loginPage = new LoginPage();
        logger.info("Click on Login tab");
        loginPage.clickLoginTab();
        logger.info("Login with valid Email and invalid Password");
        loginPage.loginAccount(Account.USERNAME.getAccount(), Utilities.generateRandomStringWithSpecialCharacter(8));
        Assert.assertEquals(loginPage.getTextLblErrorMessageLogin(), "Invalid username or password. Please try again.");
    }
}
