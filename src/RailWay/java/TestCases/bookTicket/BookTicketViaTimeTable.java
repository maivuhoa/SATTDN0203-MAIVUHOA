package TestCases.bookTicket;

import Common.utilities.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.TimeTablePage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketViaTimeTable extends BaseTest {
    private static final Logger logger = LogManager.getLogger(BookTicketViaTimeTable.class);

    @Test
    public void testBookTicketViaTimetable() {
        registerNewAccount();
        LoginPage loginPage = new LoginPage();
        TimeTablePage timeTablePage = new TimeTablePage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        loginPage.clickLoginTab();
        loginPage.loginAccount(getEmail(), getPassword());
        timeTablePage.clickTimeTableTab();
        logger.info("Click on Timetable tab");
        timeTablePage.selectDepartFromAndArrive();
        logger.info("Click on book ticket link of the route from Huế to Sài Gòn");
        Utilities.scrollIntoView(bookTicketPage.getElementBtnBookTicket());
        Assert.assertEquals(bookTicketPage.getSelectedDepartFrom(), "Huế");
        Assert.assertEquals(bookTicketPage.getSelectedArriveAt(), "Sài Gòn");

    }
}
