package TestCases.changePassword;

import Common.utilities.Utilities;
import PageObjects.ChangePassWordPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePassWordTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ChangePassWordTest.class);

    @Test(description = "TC09 : User can change password")
    public void testChangePassWordSuccess() {
        String password = Utilities.generateRandomString(8);
        String email = Utilities.generateRandomEmail(10);
        String pid = Utilities.generateRandomString(10);
        String newPassword = Utilities.generateRandomString(8);
        RegisterPage registerPage = new RegisterPage();
        logger.info("Register new account");
        registerPage.clickRegisterTab();
        registerPage.register(email, password, password, pid);

        LoginPage loginPage = new LoginPage();
        logger.info("Login with new account");
        loginPage.clickLoginTab();
        loginPage.loginAccount(email, password);

        ChangePassWordPage changePassWordPage = new ChangePassWordPage();
        logger.info("Change password");
        changePassWordPage.clickChangePassWordTab();
        changePassWordPage.changePass(password, newPassword, newPassword);
        Assert.assertEquals(changePassWordPage.getTextChangePassSuccess(), "Your password has been updated!");
    }
}
