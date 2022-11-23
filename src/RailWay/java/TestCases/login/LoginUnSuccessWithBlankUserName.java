package TestCases.login;

import Common.utilities.Utilities;
import DataObjects.Account;
import PageObjects.LoginPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUnSuccessWithBlankUserName extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginUnSuccessWithBlankUserName.class);

    @Test(description = "TC-02: User can't login with blank Username textbox")
    public void testLoginFailWithBlankUsername() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginTab();
        logger.info("Step #2: Click on Login tab");
        loginPage.loginAccount("", Account.PASSWORD.getAccount());
        logger.info("Step #3: User doesn't type any words into Username textbox but enter valid information into Password textbox");
        logger.info("Step #4: Click on Login button");
        Assert.assertEquals(loginPage.getTextLblErrorMessageLogin(), "There was a problem with your login and/or errors exist in your form.");
    }
}
