package TestCases.cancelTicket;

import Common.utilities.DriverManager;
import Common.utilities.Utilities;
import DataObjects.SeatType;
import DataObjects.Station;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import PageObjects.RegisterPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CancelTicket extends BaseTest {
    private static final Logger logger = LogManager.getLogger(CancelTicket.class);

    @Test(description = "TC16 : User can cancel a ticket")
    public void cancelTicketSuccess() {
        RegisterPage registerPage = new RegisterPage();
        logger.info("Register a new account");
        registerPage.registerNewAccount();

        LoginPage loginPage = new LoginPage();
        logger.info("Login with new account");
        loginPage.clickLoginTab();
        loginPage.loginAccount(registerPage.getEmail(), registerPage.getPassword());

        BookTicketPage bookTicketPage = new BookTicketPage();
        String departDate = Utilities.randomNumber();
        logger.info("Book a ticket");
        bookTicketPage.clickBookTicketTab();
        bookTicketPage.bookTicketKetSuccess(departDate, Station.SAIGON.getStation(), Station.NHATRANG.getStation(), SeatType.SBWAC.getSeatType(), "1");

        MyTicketPage myTicketPage = new MyTicketPage();
        logger.info("Cancel a ticket");
        String idTicket = bookTicketPage.getIDTicket();
        myTicketPage.clickMyTicketTab();
        myTicketPage.clickBtnCancelTicket(idTicket);
        DriverManager.acceptAlert();
        Assert.assertFalse(myTicketPage.isElementPresent(idTicket));
    }
}
