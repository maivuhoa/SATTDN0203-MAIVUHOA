package TestCases.cancelTicket;

import Common.utilities.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.MyTicketPage;
import TestCases.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CancelTicket extends BaseTest {
    @Test
    public void cancelTicketSuccess() {
        registerNewAccount();
        LoginPage loginPage = new LoginPage();
        BookTicketPage bookTicketPage = new BookTicketPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        String departDate = Utilities.randomNumber();
        loginPage.clickLoginTab();
        loginPage.loginAccount(getEmail(), getPassword());
        bookTicketPage.clickBookTicketTab();
        bookTicketPage.bookTicketKetSuccess(departDate,"Sài Gòn","Nha Trang","Soft bed with air conditioner", "1");
        myTicketPage.clickMyTicketTab();
        myTicketPage.clickBtnCancelTicket();
        myTicketPage.acceptOKCancel();
        String myTableIsDisplayed = String.valueOf(myTicketPage.isElementPresent(By.xpath("//table[@class='MyTable']")));
        Assert.assertEquals(myTableIsDisplayed, "false");
        System.out.println("TC16- User can cancel a ticket");
    }
}
