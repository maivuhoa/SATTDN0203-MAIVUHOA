package TestCases;

import Common.Common.Utilities;
import Common.Constant.CONSTANT;
import PageObjects.HomePage;
import PageObjects.RegisterPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegisterTest extends SetUp{



    @BeforeTest
    public void setup(){
       super.setup();
    }
    @Test(dataProvider = "Valid Email Length")
    public void testRegisterSuccess(int len){
        System.out.println("TC03- User can register with valid account");
        HomePage homePage=new HomePage();
        homePage.open();
        RegisterPage registerPage=new RegisterPage(CONSTANT.WEBDRIVER);
        registerPage.gotoRegisterPage();
        String password = Utilities.generateRandomString(8);
        String confirmPass = password;
        String email = Utilities.generateRandomEmail(len);
        String PID = Utilities.generateRandomString(8);

        registerPage.testRegister(email,password,confirmPass,PID);
        Assert.assertEquals(registerPage.getRegisterSuccessMess().getText(),"You're here");
    }
    @Test(dataProvider = "InValid Email Length")
    public void testRegisterUnSuccessWithInValidEmail(int len){
        System.out.println("TC04- User can not register with invalid email");
        HomePage homePage=new HomePage();
        homePage.open();
        RegisterPage registerPage=new RegisterPage(CONSTANT.WEBDRIVER);
        registerPage.gotoRegisterPage();
        String password = Utilities.generateRandomString(8);
        String confirmPass = password;
        String email = Utilities.generateRandomEmail(len);
        String PID = Utilities.generateRandomString(8);

        registerPage.testRegister(email,password,confirmPass,PID);
        Assert.assertEquals(registerPage.getLblErrorEmail().getText(),"Invalid email length");
    }

    @AfterTest
    public void afterClass() {
        super.afterClass();
    }
}


