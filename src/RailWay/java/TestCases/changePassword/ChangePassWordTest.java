package TestCases.changePassword;

import Common.utilities.Utilities;
import Common.constant.Constant;
import PageObjects.*;
import TestCases.SetUpBaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ChangePassWordTest extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(ChangePassWordTest.class);

    @BeforeMethod
    public void setup() {
        super.beforeTest();
    }

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
        loginPage.getBtnLogin().click();
        logger.info("Step #3: Login with new account");
        ChangePassWordPage changePassWordPage = new ChangePassWordPage();
        changePassWordPage.gotoTabChangePassWord();
        logger.info("Step #4: Navigate to Change Password page");
        changePassWordPage.changePass(password, newPassword, newPassword);
        logger.info("Step #5: Change password");
        Assert.assertEquals(changePassWordPage.getMessageSuccessChangePass().getText(), "Your password has been updated!");
        System.out.println("TC09- User can change password");
    }

    @AfterMethod
    public void afterMethod() {
        super.afterTest();
    }
}
