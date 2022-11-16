package TestCases.login;

import Common.utilities.Utilities;
import PageObjects.*;
import Common.constant.Constant;
import TestCases.SetUpBaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginUnSuccessWithInvalidPassword extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(LoginUnSuccessWithInvalidPassword.class);

    @Test()
    public void testLoginFailWithInValidPassword() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.getTabLogin().click();
        logger.info("Step #2: Click on Login tab");
        loginPage.testLogin(Constant.LOGIN_USERNAME, Utilities.generateRandomStringWithSpecialCharacter(8));
        logger.info("Step #3: Enter valid Email and invalid Password");
        loginPage.getBtnLogin().click();
        logger.info("Step #4: Click on Login button");
        Assert.assertEquals(loginPage.getPErrorMessageLogin().getText(), "Invalid username or password. Please try again.");
        System.out.println("TC03- User cannot log into Railway with invalid password ");
    }
}
