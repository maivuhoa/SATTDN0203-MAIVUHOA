package TestCases.bookTicket;

import Common.constant.SeatType;
import Common.constant.Station;
import Common.utilities.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import TestCases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketSuccess extends BaseTest {
    @Test
    public void bookTicketSuccessfully() {
        registerNewAccount();
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginTab();
        loginPage.loginAccount(getEmail(), getPassword());
        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.clickBookTicketTab();
        String departDate = Utilities.randomNumber();
        String departDayValue = bookTicketPage.getValueDateDepart(departDate);
        bookTicketPage.bookTicketKetSuccess(departDate,Station.SAIGON.getStation(), Station.NHATRANG.getStation(), SeatType.SBWAC.getSeatType(), "1");
        Assert.assertEquals(bookTicketPage.getTextLblBookTicketSuccess(), "Ticket Booked Successfully!");
        Assert.assertEquals(departDayValue, bookTicketPage.getTextInformationTicket("Depart Date"));
        Assert.assertEquals(Station.SAIGON.getStation(), bookTicketPage.getTextInformationTicket("Depart Station"));
        Assert.assertEquals(Station.NHATRANG.getStation(), bookTicketPage.getTextInformationTicket("Arrive Station"));
        Assert.assertEquals(SeatType.SBWAC.getSeatType(), bookTicketPage.getTextInformationTicket("Seat Type"));
        Assert.assertEquals("1", bookTicketPage.getTextInformationTicket("Amount"));
        System.out.println("TC14- User can book 1 ticket at a time");

    }
}
