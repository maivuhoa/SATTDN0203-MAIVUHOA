package TestCases.login;

import Common.utilities.Utilities;
import DataObjects.Account;
import PageObjects.LoginPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginSuccessWithValidEmailAndPassWord extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginSuccessWithValidEmailAndPassWord.class);

    @Test(description = "TC01 : User can log into Railway with valid username and password")
    public void testLoginSuccessWithValidAccount() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginTab();
        logger.info("Step #2: Click on Login tab");
        loginPage.loginAccount(Account.USERNAME.getAccount(), Account.PASSWORD.getAccount());
        logger.info("Step #3: Enter valid Email and Password");
        logger.info("Step #4: Click on Login button");
        Assert.assertEquals(loginPage.getTextWellCome(), "Welcome " + Account.USERNAME.getAccount());
    }
}
