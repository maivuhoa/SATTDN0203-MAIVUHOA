package TestCases.login;

import Common.utilities.Utilities;
import PageObjects.*;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageShownWhenClickBookTicketWithoutLogged extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginPageShownWhenClickBookTicketWithoutLogged.class);

    @Test()
    public void testLoginPageShownWhenUserClickBookTicketTabWithoutLogged() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        GeneralPage generalPage = new GeneralPage();
        generalPage.clickBookTicketTab();
        logger.info("Step #2: Click on Book ticket tab");
        Assert.assertEquals(loginPage.getTextLblLogin(), "Login Page");
        System.out.println("TC04- Login page displays when un-logged User clicks on Book ticket tab");
    }
}
