package TestCases.register;

import TestCases.BaseTest;
import Common.utilities.Utilities;
import PageObjects.RegisterPage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUnSuccessdWithBlankPassAndPID extends BaseTest {
    private static final Logger logger = LogManager.getLogger(RegisterUnsuccessWithPasswordNotMatch.class);

    @Test(description = "TC-11: User can't create account while password and PID fields are empty")
    public void testRegisterUnSuccessWithBlankPassAndPID() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        RegisterPage registerPage = new RegisterPage();
        registerPage.clickRegisterTab();
        logger.info("Step #2: Click on Register tab");
        String email = Utilities.generateRandomEmail(10);
        String confirmPass = Utilities.generateRandomString(10);
        registerPage.register(email, "", confirmPass, "");
        logger.info("Step #3: Enter valid email address and leave other fields empty");
        logger.info("Step #4: Click on Register button");
        Assert.assertEquals(registerPage.getTextLblErrorMessageForm(), "There're errors in the form. Please correct the errors and try again.");
    }
}
