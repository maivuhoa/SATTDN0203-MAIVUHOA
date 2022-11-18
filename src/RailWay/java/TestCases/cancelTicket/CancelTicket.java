package TestCases.cancelTicket;

import Common.constant.SeatType;
import Common.constant.Station;
import Common.utilities.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import TestCases.SetUpBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CancelTicket extends SetUpBaseTest {
    @Test
    public void cancelTicketSuccess() {
        registerNewAccount();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        String departDate = Utilities.randomNumber();
        loginPage.gotoLoginPage();
        loginPage.testLogin(getEmail(), getPassword());
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.bookTicketKetSuccess(departDate, Station.SAIGON, Station.NHATRANG, SeatType.SBWAC, "1");
        myTicketPage.gotoMyTicketPage();
        myTicketPage.clickBtnCancelTicket();
        myTicketPage.acceptOKCancel();
        String myTableIsDisplayed = String.valueOf(myTicketPage.isElementPresent(By.xpath("//table[@class='MyTable']")));
        Assert.assertEquals(myTableIsDisplayed, "false");
        System.out.println("TC16- User can cancel a ticket");
    }
}
