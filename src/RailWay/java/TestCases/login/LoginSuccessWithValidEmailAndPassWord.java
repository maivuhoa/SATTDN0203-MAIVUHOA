package TestCases.login;

import Common.utilities.Utilities;
import PageObjects.*;
import Common.constant.Constant;
import TestCases.SetUpBaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginSuccessWithValidEmailAndPassWord extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(LoginSuccessWithValidEmailAndPassWord.class);


    @BeforeMethod
    public void beforeTesting() {
        super.beforeTest();
    }

    @Test()
    public void testLoginSuccessWithValidAccount() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.getTabLogin().click();
        logger.info("Step #2: Click on Login tab");
        loginPage.testLogin(Constant.LOGIN_USERNAME, Constant.LOGIN_PASSWORD);
        logger.info("Step #3: Enter valid Email and Password");
        loginPage.getBtnLogin().click();
        logger.info("Step #4: Click on Login button");
        Assert.assertEquals(loginPage.getWellComeMes().getText(), "Welcome " + Constant.LOGIN_USERNAME);
        System.out.println("TC01- User can log into Railway with valid username and password");
    }

    @AfterMethod
    public void afterTesting() {
        super.afterTest();
    }
}