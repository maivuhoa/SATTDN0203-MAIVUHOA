package TestCases.cancelTicket;

import Common.utilities.Utilities;
import Common.utilities.listeners.ReportListener;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import PageObjects.RegisterPage;
import TestCases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
public class CancelTicket extends BaseTest {
    @Test(description = "TC16 : User can cancel a ticket")
    public void cancelTicketSuccess() {
        RegisterPage registerPage = new RegisterPage();
        registerPage.registerNewAccount();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        String departDate = Utilities.randomNumber();
        loginPage.clickLoginTab();
        loginPage.loginAccount(registerPage.getEmail(), registerPage.getPassword());
        bookTicketPage.clickBookTicketTab();
        bookTicketPage.bookTicketKetSuccess(departDate, "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        String idTicket = bookTicketPage.getIDTicket();
        myTicketPage.clickMyTicketTab();
        myTicketPage.clickBtnCancelTicket(idTicket);
        myTicketPage.acceptOKCancel();
        Assert.assertFalse(myTicketPage.isElementPresent(idTicket));
    }
}
