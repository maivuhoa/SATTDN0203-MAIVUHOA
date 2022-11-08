package TestCases;

import Common.Common.Utilities;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Common.Constant.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class TestLogin {
    LoginPage objLogin;
    @BeforeTest
    public void setup(){
        System.out.println("Pre-condition");
        System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
        Constant.WEBDRIVER =new ChromeDriver();
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Constant.WEBDRIVER.get(Constant.RailwayURL);
    }
   @Test
   public void testLoginSuccess(){
        System.out.println("TC01- User can Login with valid Username and Password !");
       HomePage homePage=new HomePage();
       homePage.open();
       LoginPage loginPage=new LoginPage();
       loginPage.getTabLogin().click();
       loginPage.testLogin(Constant.Username, Constant.Password);
       Assert.assertEquals(loginPage.getWellComeMes().getText(),"Welcome aa@gmail.com");
    }
    //For Test Login
    @Test
    public void testLoginFail(){
        System.out.println("TC01- User can Login with valid Username and Password !");
        HomePage homePage=new HomePage();
        homePage.open();
        LoginPage loginPage=new LoginPage();
        loginPage.getTabLogin().click();
        loginPage.testLogin(Constant.Username, Constant.Password);
        Assert.assertEquals(loginPage.getErrorMessageLogin().getText(),"Invalid username or password. Please try again.");
    }



    @AfterTest
    public void afterClass() {
        Constant.WEBDRIVER.quit();
    }

}
