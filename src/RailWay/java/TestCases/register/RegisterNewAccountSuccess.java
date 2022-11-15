package TestCases.register;

import Common.constant.Constant;
import Common.utilities.DriverManager;
import Common.utilities.Utilities;
import PageObjects.RegisterPage;
import TestCases.SetUpBaseTest;
import TestCases.changePassword.ChangePassWordTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterNewAccountSuccess extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(ChangePassWordTest.class);

    @BeforeTest
    public void setup() {
        super.beforeTest();
    }

    @Test(dataProvider = "Valid Email Length")
    public void testRegisterSuccess(int len) {
        DriverManager.open();
        Utilities.getLog();
        logger.info("Step #1: Register new account");
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterPage();
        logger.info("Step #2: Click on Register tab");
        String password = Utilities.generateRandomString(8);
        String confirmPass = password;
        String email = Utilities.generateRandomEmail(len);
        String PID = Utilities.generateRandomString(8);

        registerPage.testRegister(email, password, confirmPass, PID);
        registerPage.getBtnRegister().click();
        logger.info("Step #3: Enter valid information into all fields");
        Assert.assertEquals(registerPage.getRegisterSuccessMess().getText(), "You're here");
        System.out.println("TC07- User can create new account");
    }
    @AfterMethod
    public void afterMethod() {
        super.afterTest();
    }
}
