package TestCases.changePassword;

import Common.utilities.Utilities;
import PageObjects.ChangePassWordPage;
import PageObjects.LoginPage;
import PageObjects.RegisterPage;
import TestCases.SetUpBaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangePassWordTest extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(ChangePassWordTest.class);

    @Test
    public void testChangePassWordSuccess() {
        String password = Utilities.generateRandomString(8);
        String email = Utilities.generateRandomEmail(10);
        String pid = Utilities.generateRandomString(10);
        String newPassword = Utilities.generateRandomString(8);
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterPage();
        Utilities.getLog();
        registerPage.testRegister(email, password, password, pid);
        logger.info("Step #1: Register new account");
        LoginPage loginPage = new LoginPage();
        loginPage.gotoLoginPage();
        logger.info("Step #2: Navigate to Login page");
        loginPage.testLogin(email, password);
        System.out.println(password);
        logger.info("Step #3: Login with new account");
        ChangePassWordPage changePassWordPage = new ChangePassWordPage();
        changePassWordPage.gotoTabChangePassWord();
        logger.info("Step #4: Navigate to Change Password page");
        changePassWordPage.changePass(password, newPassword, newPassword);
        logger.info("Step #5: Change password");
        Assert.assertEquals(changePassWordPage.getTextChangePassSuccess(), "Your password has been updated!");
        System.out.println("TC09- User can change password");
    }
}
