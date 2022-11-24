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
        LoginPage loginPage = new LoginPage();
        String wrongPassword = Utilities.generateRandomString(8);
        logger.info("Click on Login tab");
        loginPage.clickLoginTab();
        logger.info("Enter valid information into Username textbox except Password textbox.");
        for (int i = 0; i < 4; i++) {
            loginPage.loginAccount(Account.USERNAME.getAccount(), wrongPassword);
        }
        Assert.assertEquals(loginPage.getTextLblErrorMessageLogin(), "Invalid username or password. Please try again.");
    }
}
