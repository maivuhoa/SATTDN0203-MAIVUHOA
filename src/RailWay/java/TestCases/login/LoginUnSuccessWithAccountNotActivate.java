package TestCases.login;

import TestCases.SetUpBaseTest;
import Common.utilities.DriverManager;
import Common.utilities.Utilities;
import PageObjects.*;
import Common.constant.Constant;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginUnSuccessWithAccountNotActivate extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(LoginUnSuccessWithAccountNotActivate.class);

    @Test()
    public void testAccountNotActivate() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        DriverManager.open();
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterPage();
        String password = Utilities.generateRandomString(8);
        String email = Utilities.generateRandomEmail(8);
        String PID = Utilities.generateRandomString(8);
        registerPage.testRegister(email, password, password, PID);
        loginPage.getTabLogin().click();
        loginPage.testLogin(email, password);
        String urlLogin = Constant.WEBDRIVER.getCurrentUrl();
        Assert.assertEquals(urlLogin, "http://www.railwayb2.somee.com/Account/Login.cshtml");
        System.out.println("TC08- User can't login with an account hasn't been activated");
    }
}
