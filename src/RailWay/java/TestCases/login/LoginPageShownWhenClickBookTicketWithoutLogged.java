package TestCases.login;

import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageShownWhenClickBookTicketWithoutLogged extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginPageShownWhenClickBookTicketWithoutLogged.class);

    @Test(description = "TC04 : Login page displays when un-logged User clicks on Book ticket tab")
    public void testLoginPageShownWhenUserClickBookTicketTabWithoutLogged() {
        logger.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.clickBookTicketTab();
        logger.info("Click on Book ticket tab");
        Assert.assertEquals(loginPage.getTextLblLogin(), "Login Page");
    }
}
