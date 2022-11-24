package TestCases.login;

import DataObjects.Account;
import PageObjects.ChangePassWordPage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdditionalPagesDisplayOnceUserLoggedin extends BaseTest {
    private static final Logger logger = LogManager.getLogger(AdditionalPagesDisplayOnceUserLoggedin.class);

    @Test(description = "TC06 : Additional pages display once user logged in")
    public void testAdditionalPagesDisplay() {
        logger.info("Login with valid account");
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginTab();
        loginPage.loginAccount(Account.USERNAME.getAccount(), Account.PASSWORD.getAccount());

        MyTicketPage myTicketPage = new MyTicketPage();
        logger.info("Click My Ticket tab");
        myTicketPage.clickMyTicketTab();
        Assert.assertEquals(myTicketPage.getTextManageTicket(), "Manage Tickets");

        ChangePassWordPage changePassWordPage = new ChangePassWordPage();
        logger.info("Click Change Password tab");
        changePassWordPage.clickChangePassWordTab();
        Assert.assertEquals(changePassWordPage.getTextLblChangePassWord(), "Change password");

        logger.info("Logout page is displayed");
        Assert.assertTrue(loginPage.isTabDisplayed("Log out"));
    }
}
