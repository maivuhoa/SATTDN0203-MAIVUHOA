package TestCases.login;

import DataObjects.Account;
import PageObjects.LoginPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUnSuccessWithBlankUserName extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LoginUnSuccessWithBlankUserName.class);

    @Test(description = "TC-02: User can't login with blank Username textbox")
    public void testLoginFailWithBlankUsername() {
        logger.info("Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.clickLoginTab();
        logger.info("Click on Login tab");
        loginPage.loginAccount("", Account.PASSWORD.getAccount());
        logger.info("Enter valid information into password textbox but leave the email blank");
        Assert.assertEquals(loginPage.getTextLblErrorMessageLogin(), "There was a problem with your login and/or errors exist in your form.");
    }
}
