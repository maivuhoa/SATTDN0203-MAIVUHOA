package TestCases.register;

import TestCases.SetUpBaseTest;
import Common.constant.Constant;
import Common.utilities.DriverManager;
import Common.utilities.Utilities;
import PageObjects.RegisterPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterUnsuccessWithPasswordNotMatch extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(RegisterUnsuccessWithPasswordNotMatch.class);
    @Test
    public void testRegisterUnSuccessWithPassNotMatch() {
        DriverManager.open();
        Utilities.getLog();
        logger.info("Step #1: Register new account");
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterPage();
        logger.info("Step #2:  Click on Register tab");
        String password = Utilities.generateRandomString(8);
        String confirmPass = Utilities.generateRandomString(9);
        String email = Utilities.generateRandomEmail(8);
        String PID = Utilities.generateRandomString(8);
        registerPage.testRegister(email, password, confirmPass, PID);
        logger.info("Step #3: Enter valid information into all fields except Confirm password is not the same with Password");
        Assert.assertEquals(registerPage.getpaErrorMessageForm().getText(), "There're errors in the form. Please correct the errors and try again.");
        System.out.println("TC10- User can't create account with Confirm password is not the same with Password");
    }
}
