package TestCases.bookTicket;

import Common.constant.Constant;
import Common.utilities.Utilities;
import PageObjects.BookTicketPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import TestCases.SetUpBaseTest;
import org.testng.annotations.Test;
import TestCases.register.RegisterNewAccountSuccess;

public class BookTicketSuccess extends RegisterNewAccountSuccess {

    @Test
    public void bookTicketSuccessfully() {
        RegisterNewAccountSuccess registerNewAccountSuccess = new RegisterNewAccountSuccess();
        registerNewAccountSuccess.testRegisterSuccess(8);
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        loginPage.testLogin(Constant.LOGIN_USERNAME, Constant.LOGIN_PASSWORD);
        loginPage.getBtnLogin().click();
        BookTicketPage bookTicketPage = new BookTicketPage();
        bookTicketPage.gotoBookTicketPage();
        bookTicketPage.selectDate();
        bookTicketPage.selectDepartFrom();
        bookTicketPage.selectArriveAt();
        bookTicketPage.selectSeatType();
        bookTicketPage.selectTicketAmount();

    }
}
