package TestCases.bookTicket;

import Common.constant.Constant;
import Common.utilities.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import TestCases.SetUpBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTicketSuccess extends SetUpBaseTest {
    @Test
    public void bookTicketSuccessfully() {
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        loginPage.testLogin(Constant.LOGIN_USERNAME, Constant.LOGIN_PASSWORD);
        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.gotoBookTicketPage();
        String departDate = Utilities.randomNumber();
        String departDayValue = bookTicketPage.getValueDateDepart(departDate);

        bookTicketPage.bookTicketKetSuccess(departDate, "1", "3", "6", "1");

        Assert.assertEquals(bookTicketPage.getTextLblBookTicketSuccess(), "Ticket Booked Successfully!");
        Assert.assertEquals(departDayValue, bookTicketPage.getTextInformationTicket("Depart Date"));
        Assert.assertEquals("Sài Gòn", bookTicketPage.getTextInformationTicket("Depart Station"));
        Assert.assertEquals("Nha Trang", bookTicketPage.getTextInformationTicket("Arrive Station"));
        Assert.assertEquals("Soft bed with air conditioner", bookTicketPage.getTextInformationTicket("Seat Type"));
        Assert.assertEquals("1", bookTicketPage.getTextInformationTicket("Amount"));
        System.out.println("TC14- User can book 1 ticket at a time");

    }
}
