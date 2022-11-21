package TestCases.register;

import Common.utilities.Utilities;
import PageObjects.RegisterPage;
import TestCases.BaseTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterNewAccountSuccess extends BaseTest {
    private static final Logger logger = LogManager.getLogger(RegisterNewAccountSuccess.class);

    @Test(dataProvider = "Valid Email Length")
    public void testRegisterSuccess(int len) {
        Utilities.getLog();
        logger.info("Step #1: Register new account");
        RegisterPage registerPage = new RegisterPage();
        registerPage.clickRegisterTab();
        logger.info("Step #2: Click on Register tab");
        String password = Utilities.generateRandomString(8);
        String email = Utilities.generateRandomEmail(len);
        String PID = Utilities.generateRandomString(8);
        registerPage.testRegister(email, password, password, PID);
        registerPage.clickBtnRegister();
        logger.info("Step #3: Enter valid information into all fields");
        Assert.assertEquals(registerPage.getTextRegisterSuccessMess(), "You're here");
        System.out.println("TC07- User can create new account");
    }
}
