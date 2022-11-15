package TestCases.login;

import Common.utilities.Utilities;
import PageObjects.*;
import TestCases.SetUpBaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageShownWhenClickBookTicketWithoutLogged extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(LoginPageShownWhenClickBookTicketWithoutLogged.class);


    @BeforeMethod
    public void beforeTesting() {
        super.beforeTest();
    }

    @Test()
    public void testLoginPageShownWhenUserClickBookTicketTabWithoutLogged() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        GeneralPage generalPage = new GeneralPage();
        generalPage.gotoBookTicketPage();
        logger.info("Step #2: Click on Book ticket tab");
        Assert.assertEquals(loginPage.getTxtLoginPage().getText(), "Login Page");
        System.out.println("TC04- Login page displays when un-logged User clicks on Book ticket tab");
    }

    @AfterMethod
    public void afterTesting() {
        super.afterTest();
    }
}
