package TestCases.bookTicket;

import Common.utilities.Utilities;
import DataObjects.SeatType;
import DataObjects.Station;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketSuccess extends BaseTest {
    private static final Logger logger = LogManager.getLogger(BookTicketSuccess.class);

    @Test(description = "TC14 : User can book 1 ticket at a time")
    public void bookTicketSuccessfully() {
        RegisterPage registerPage = new RegisterPage();
        logger.info("Register new account");
        registerPage.registerNewAccount();

        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginTab();
        logger.info("Login with new account");
        loginPage.loginAccount(registerPage.getEmail(), registerPage.getPassword());

        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.clickBookTicketTab();
        String departDate = Utilities.randomNumber();
        String departDayValue = bookTicketPage.getValueDateDepart(departDate);
        logger.info("Book a ticket");
        bookTicketPage.bookTicketKetSuccess(departDate, Station.SAIGON.getStation(), Station.NHATRANG.getStation(), SeatType.SBWAC.getSeatType(), "1");

        Assert.assertEquals(bookTicketPage.getTextLblBookTicketSuccess(), "Ticket Booked Successfully!");
        Assert.assertEquals(departDayValue, bookTicketPage.getTextInformationTicket("Depart Date"));
        Assert.assertEquals(Station.SAIGON.getStation(), bookTicketPage.getTextInformationTicket("Depart Station"));
        Assert.assertEquals(Station.NHATRANG.getStation(), bookTicketPage.getTextInformationTicket("Arrive Station"));
        Assert.assertEquals(SeatType.SBWAC.getSeatType(), bookTicketPage.getTextInformationTicket("Seat Type"));
        Assert.assertEquals("1", bookTicketPage.getTextInformationTicket("Amount"));
    }
}
