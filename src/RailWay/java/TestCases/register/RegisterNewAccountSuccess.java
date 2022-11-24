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

    @Test(dataProvider = "Valid Email Length", description = "TC-07 : User can create new account")
    public void testRegisterSuccess(int len) {
        RegisterPage registerPage = new RegisterPage();
        logger.info("Click on Register tab");
        registerPage.clickRegisterTab();
        String password = Utilities.generateRandomString(8);
        String email = Utilities.generateRandomEmail(len);
        String PID = Utilities.generateRandomString(8);
        logger.info("Enter valid information into all fields");
        registerPage.register(email, password, password, PID);
        Assert.assertEquals(registerPage.getTextRegisterSuccessMess(), "You're here");
    }
}
