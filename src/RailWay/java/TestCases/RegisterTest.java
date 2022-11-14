package TestCases;

import Common.utilities.DriverManager;
import Common.utilities.Utilities;
import Common.constant.Constant;
import PageObjects.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest extends SetUpBaseTest {
    Utilities utilities = new Utilities();


    @BeforeTest
    public void setup() {
        super.beforeTest();
    }

    @Test(dataProvider = "Valid Email Length")
    public void testRegisterSuccess(int len) {
        System.out.println("TC07- User can create new account");
        DriverManager.open();
        RegisterPage registerPage = new RegisterPage(Constant.WEBDRIVER);
        registerPage.gotoRegisterPage();
        String password = Utilities.generateRandomString(8);
        String confirmPass = password;
        String email = Utilities.generateRandomEmail(len);
        String PID = Utilities.generateRandomString(8);

        registerPage.testRegister(email, password, confirmPass, PID);
        Assert.assertEquals(registerPage.getRegisterSuccessMess().getText(), "You're here");
    }

    @Test(dataProvider = "InValid Email Length")
    public void testRegisterUnSuccessWithInValidEmail(int len) {
        System.out.println("TC04- User can not register with invalid email");
        DriverManager.open();
        RegisterPage registerPage = new RegisterPage(Constant.WEBDRIVER);
        registerPage.gotoRegisterPage();
        String password = Utilities.generateRandomString(8);
        String confirmPass = password;
        String email = Utilities.generateRandomEmail(len);
        String PID = Utilities.generateRandomString(8);

        registerPage.testRegister(email, password, confirmPass, PID);
        Assert.assertEquals(registerPage.getLblErrorEmail().getText(), "Invalid email length");
    }

    @Test
    public void testRegisterUnsuccessWithPassNotMatch() {
        System.out.println("TC10- User can't create account with Confirm password is not the same with Password");
        DriverManager.open();
        RegisterPage registerPage = new RegisterPage(Constant.WEBDRIVER);
        registerPage.gotoRegisterPage();
        String password = Utilities.generateRandomString(8);
        String confirmPass = Utilities.generateRandomString(9);
        String email = Utilities.generateRandomEmail(8);
        String PID = Utilities.generateRandomString(8);

        registerPage.testRegister(email, password, confirmPass, PID);
        Assert.assertEquals(registerPage.getpaErrorMessageForm().getText(), "There're errors in the form. Please correct the errors and try again.");
    }

    @Test
    public void testRegisterUnsuccessWithBankPassAndPID() {
        System.out.println("TC11- User can't create account while password and PID fields are empty");
        DriverManager.open();
        RegisterPage registerPage = new RegisterPage(Constant.WEBDRIVER);
        registerPage.gotoRegisterPage();
        String email = Utilities.generateRandomEmail(10);
        String confirmPass = Utilities.generateRandomString(10);
        registerPage.testRegister(email, "", confirmPass, "");
        Assert.assertEquals(registerPage.getpaErrorMessageForm().getText(), "There're errors in the form. Please correct the errors and try again.");

    }

    @AfterTest
    public void afterClass() {
        super.afterTest();
    }
}


