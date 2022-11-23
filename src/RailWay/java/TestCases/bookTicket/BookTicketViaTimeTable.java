package TestCases.bookTicket;

import Common.utilities.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import PageObjects.TimeTablePage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketViaTimeTable extends BaseTest {
    private static final Logger logger = LogManager.getLogger(BookTicketViaTimeTable.class);

    @Test(description = "TC15 : User can open Book ticket page by clicking on Book ticket link in Train timetable page")
    public void testBookTicketViaTimetable() {
        Utilities.getLog();
        RegisterPage registerPage = new RegisterPage();
        logger.info("Register a new account");
        registerPage.registerNewAccount();
        LoginPage loginPage = new LoginPage();
        TimeTablePage timeTablePage = new TimeTablePage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        loginPage.clickLoginTab();
        logger.info("Log in with new account");
        loginPage.loginAccount(registerPage.getEmail(), registerPage.getPassword());
        logger.info("Click on Timetable tab");
        timeTablePage.clickTimeTableTab();
        logger.info("Click on book ticket link of the route from Huế to Sài Gòn");
        timeTablePage.selectDepartFromAndArrive();
        Assert.assertEquals(bookTicketPage.getSelectedDepartFrom(), "Huế");
        Assert.assertEquals(bookTicketPage.getSelectedArriveAt(), "Sài Gòn");
    }
}
