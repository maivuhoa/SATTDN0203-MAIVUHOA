package TestCases;

import Common.utilities.DriverManager;
import Common.utilities.Utilities;
import PageObjects.*;
import Common.constant.Constant;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends SetUpBaseTest {
    private static final Logger logger = LogManager.getLogger(LoginTest.class);


    @BeforeMethod
    public void beforeTesting() {
        super.beforeTest();
    }

    @Test()
    public void testLoginSuccessWithValidAccount() {
        Utilities.getLog();
        logger.info("Step #1: Navigate to QA Railway Website");
        LoginPage loginPage = new LoginPage();
        loginPage.getTabLogin().click();
        logger.info("Step #2: Click on Login tab");
        loginPage.testLogin(Constant.LOGIN_USERNAME, Constant.LOGIN_PASSWORD);
        logger.info("Step #3: Enter valid Email and Password");
        loginPage.getBtnLogin().click();
        logger.info("Step #4: Click on Login button");
        Assert.assertEquals(loginPage.getWellComeMes().getText(), "Welcome " + Constant.LOGIN_USERNAME);
        System.out.println("TC01- User can log into Railway with valid username and password");
    }

    @Test
    public void testLoginFailWithBlankUsername() {

        LoginPage loginPage = new LoginPage();
        loginPage.getTabLogin().click();
        loginPage.testLogin("", Constant.LOGIN_PASSWORD);
        loginPage.getBtnLogin().click();
        Assert.assertEquals(loginPage.getPErrorMessageLogin().getText(), "There was a problem with your login and/or errors exist in your form.");
    }

    @Test(enabled = false)
    public void testLoginFailWithInValidPassword() {
        System.out.println("TC03- User cannot log into Railway with invalid password ");
        LoginPage loginPage = new LoginPage();
        loginPage.getTabLogin().click();
        loginPage.testLogin(Constant.LOGIN_USERNAME, Utilities.generateRandomStringWithSpecialCharacter(8));
        loginPage.getBtnLogin().click();
        Assert.assertEquals(loginPage.getPErrorMessageLogin().getText(), "There was a problem with your login and/or errors exist in your form.");
    }

    @Test(enabled = false)
    public void testLoginPageShownWhenUserNavigatetoBookTicket() {
        System.out.println("TC04- Login page displays when un-logged User clicks on Book ticket tab");
        LoginPage loginPage = new LoginPage();
        GeneralPage generalPage = new GeneralPage();
        generalPage.gotoBookTicketPage();
        Assert.assertEquals(loginPage.getTxtLoginPage().getText(), "Login Page");
    }

    @Test(enabled = false)
    public void testEnterWrongPasswordSeveralTime() {
        System.out.println("TC05- System shows message when user enters wrong password several times");
        LoginPage loginPage = new LoginPage();
        String wrongPassword = Utilities.generateRandomString(8);
        loginPage.getTabLogin().click();
        for (int i = 0; i < 4; i++) {
            loginPage.testLogin(Constant.LOGIN_USERNAME, wrongPassword);
            loginPage.getBtnLogin().click();
        }
        Assert.assertEquals(loginPage.getPErrorMessageLogin().getText(), "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");

    }

    @Test(enabled = false)
    public void testAdditionalPagesDisplay() {
        System.out.println("TC06- Additional pages display once user logged in");
        LoginPage loginPage = new LoginPage();
        GeneralPage generalPage = new GeneralPage();
        MyTicketPage myTicketPage = new MyTicketPage();
        LogoutPage logoutPage = new LogoutPage();
        HomePage homePage = new HomePage();
        ChangePassWordPage changePassWordPage = new ChangePassWordPage();
        loginPage.getTabLogin().click();
        loginPage.testLogin(Constant.LOGIN_USERNAME, Constant.LOGIN_PASSWORD);
        loginPage.getBtnLogin().click();
        myTicketPage.gotoMyTicketPage();
        Assert.assertEquals(myTicketPage.geth1ManageTickets().getText(), "Manage Tickets");
        changePassWordPage.gotoTabChangePassWord();
        Assert.assertEquals(changePassWordPage.getLblChangePassword().getText(), "Change password");
        logoutPage.gotoTabLogout();
        Assert.assertEquals(homePage.geth1WellComeRailWay().getText(), "Welcome to Safe Railway");

    }

    @Test(enabled = false)
    public void testAccountNotActivate() {
        System.out.println("TC08- User can't login with an account hasn't been activated");
        DriverManager.open();
        RegisterPage registerPage = new RegisterPage(Constant.WEBDRIVER);
        registerPage.gotoRegisterPage();
        String password = Utilities.generateRandomString(8);
        String confirmPass = password;
        String email = Utilities.generateRandomEmail(8);
        String PID = Utilities.generateRandomString(8);

        registerPage.testRegister(email, password, confirmPass, PID);
        LoginPage loginPage = new LoginPage();
        loginPage.getTabLogin().click();
        loginPage.testLogin(email, password);
        loginPage.getBtnLogin().click();
        String urlLogin = Constant.WEBDRIVER.getCurrentUrl();
        Assert.assertEquals(urlLogin, "http://www.railwayb2.somee.com/Account/Login.cshtml");

    }

    @AfterMethod
    public void afterTesting() {
        super.afterTest();
    }
}
