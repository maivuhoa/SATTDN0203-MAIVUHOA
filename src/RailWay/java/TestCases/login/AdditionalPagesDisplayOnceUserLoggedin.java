package TestCases.login;

import TestCases.BaseTest;
import Common.utilities.Utilities;
import PageObjects.*;
import Common.constant.Constant;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class AdditionalPagesDisplayOnceUserLoggedin extends BaseTest {
    private static final Logger logger = LogManager.getLogger(AdditionalPagesDisplayOnceUserLoggedin.class);

    @Test
    public void testAdditionalPagesDisplay() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        HomePage homePage = new HomePage();
        GeneralPage generalPage = new GeneralPage();
        ChangePassWordPage changePassWordPage = new ChangePassWordPage();
        loginPage.clickLoginTab();
        logger.info("Step #2: Click on Login tab");
        loginPage.loginAccount(Constant.LOGIN_USERNAME, Constant.LOGIN_PASSWORD);
        logger.info("Step #3: Login with valid account");
        myTicketPage.clickMyTicketTab();
        Assert.assertEquals(myTicketPage.getTextManageTicket(), "Manage Tickets");
        changePassWordPage.clickChangePassWordTab();
        Assert.assertEquals(changePassWordPage.getTextLblChangePassWord(), "Change password");
        generalPage.clickLogoutTab();
        Assert.assertEquals(homePage.getTextLblWellComeRailWay(), "Welcome to Safe Railway");
        System.out.println("TC06- Additional pages display once user logged in");
    }
}
