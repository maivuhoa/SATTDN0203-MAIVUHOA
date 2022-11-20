package TestCases.login;

import TestCases.SetUpBaseTest;
import Common.utilities.Utilities;
import PageObjects.*;
import Common.constant.Constant;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
public class AdditionalPagesDisplayOnceUserLoggedin extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(AdditionalPagesDisplayOnceUserLoggedin.class);


    @BeforeMethod
    public void beforeTesting() {
        super.beforeTest();
    }
    @Test
    public void testAdditionalPagesDisplay() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();

        MyTicketPage myTicketPage = new MyTicketPage();
        LogoutPage logoutPage = new LogoutPage();
        HomePage homePage = new HomePage();
        ChangePassWordPage changePassWordPage = new ChangePassWordPage();
        loginPage.getTabLogin().click();
        logger.info("Step #2: Click on Login tab");
        loginPage.testLogin(Constant.LOGIN_USERNAME, Constant.LOGIN_PASSWORD);
        loginPage.getBtnLogin().click();
        logger.info("Step #3: Login with valid account");
        myTicketPage.gotoMyTicketPage();
        Assert.assertEquals(myTicketPage.geth1ManageTickets().getText(), "Manage Tickets");
        changePassWordPage.gotoTabChangePassWord();
        Assert.assertEquals(changePassWordPage.getLblChangePassword().getText(), "Change password");
        logoutPage.gotoTabLogout();
        Assert.assertEquals(homePage.geth1WellComeRailWay().getText(), "Welcome to Safe Railway");
        System.out.println("TC06- Additional pages display once user logged in");
    }
    @AfterMethod
    public void afterTesting() {
        super.afterTest();
    }
}
