package TestCases.login;

import Common.utilities.Utilities;
import PageObjects.*;
import Common.constant.Constant;
import TestCases.SetUpBaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginUnSuccessWithBlankUserName extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(LoginUnSuccessWithBlankUserName.class);

    @Test
    public void testLoginFailWithBlankUsername() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.getTabLogin().click();
        logger.info("Step #2: Click on Login tab");
        loginPage.testLogin("", Constant.LOGIN_PASSWORD);
        logger.info("Step #3: User doesn't type any words into Username textbox but enter valid information into Password textbox");
        loginPage.getBtnLogin().click();
        logger.info("Step #4: Click on Login button");
        Assert.assertEquals(loginPage.getPErrorMessageLogin().getText(), "There was a problem with your login and/or errors exist in your form.");
    }
}
