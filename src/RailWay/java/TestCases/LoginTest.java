package TestCases;

import Common.Common.Utilities;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Common.Constant.CONSTANT;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class LoginTest extends SetUp {

    @BeforeTest
    public void setup() {
        super.setup();
    }

    @Test
   public void testLoginSuccessWithValidEmailLength(){
        System.out.println("TC01- User can Login with valid Username and Password !");
       HomePage homePage=new HomePage();
       homePage.open();
       LoginPage loginPage=new LoginPage();
       loginPage.getTabLogin().click();
       String email = Utilities.generateRandomEmail(8);
       loginPage.testLogin("aa@gmail.com", "12345678");
       Assert.assertEquals(loginPage.getWellComeMes().getText(),"Welcome aa@gmail.com");
    }
    //For Test Login
    @Test(enabled = false)
    public void testLoginFail(){
        System.out.println("TC02- User can not Login with invalid Username and Password !");
        HomePage homePage=new HomePage();
        homePage.open();
        LoginPage loginPage=new LoginPage();
        loginPage.getTabLogin().click();
        loginPage.testLogin(CONSTANT.loginUsername, CONSTANT.loginPassword);
        Assert.assertEquals(loginPage.getErrorMessageLogin().getText(),"Invalid username or password. Please try again.");
    }

    public void afterClass(){
        super.afterClass();
    }




}
