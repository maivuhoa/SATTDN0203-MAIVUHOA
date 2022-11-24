package TestCases.bookTicket;

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
        RegisterPage registerPage = new RegisterPage();
        logger.info("Register a new account");
        registerPage.registerNewAccount();

        LoginPage loginPage = new LoginPage();
        logger.info("Log in with new account");
        loginPage.clickLoginTab();
        loginPage.loginAccount(registerPage.getEmail(), registerPage.getPassword());


        TimeTablePage timeTablePage = new TimeTablePage();
        logger.info("Click on Timetable tab");
        timeTablePage.clickTimeTableTab();
        timeTablePage.selectDepartFromAndArrive();

        BookTicketPage bookTicketPage = new BookTicketPage();
        logger.info("Click on book ticket link of the route from Huế to Sài Gòn");
        Assert.assertEquals(bookTicketPage.getSelectedDepartFrom(), "Huế");
        Assert.assertEquals(bookTicketPage.getSelectedArriveAt(), "Sài Gòn");
    }
}
