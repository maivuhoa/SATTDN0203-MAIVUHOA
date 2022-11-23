package TestCases.login;

import Common.utilities.Utilities;
import DataObjects.Account;
import PageObjects.LoginPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEnterWrongPasswordSeveralTime extends BaseTest {
    private static final Logger logger = LogManager.getLogger(TestEnterWrongPasswordSeveralTime.class);

    @Test(description = "TC-05: System shows message when user enters wrong password several times")
    public void testEnterWrongPasswordSeveralTime() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        String wrongPassword = Utilities.generateRandomString(8);
        loginPage.clickLoginTab();
        logger.info("Step #2: Click on Login tab");
        for (int i = 0; i < 4; i++) {
            loginPage.loginAccount(Account.USERNAME.getAccount(), wrongPassword);
        }
        logger.info("Step #3: Enter valid information into Username textbox except Password textbox.");
        Assert.assertEquals(loginPage.getTextLblErrorMessageLogin(), "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");
    }
}
