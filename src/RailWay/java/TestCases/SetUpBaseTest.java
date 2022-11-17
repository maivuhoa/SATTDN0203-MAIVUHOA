package TestCases;

import Common.utilities.DriverManager;
import Common.utilities.Utilities;
import PageObjects.RegisterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class SetUpBaseTest {

    private String email;
    private String password;

    protected String getEmail() {
        return email;
    }

    protected String getPassword() {
        return password;
    }

    @DataProvider(name = "Valid Email Length")
    public Object[][] ValidEmaillength() {
        return new Object[][]{{6}, {7}, {31}, {32}};
    }

    @DataProvider(name = "InValid Email Length")
    public Object[][] InvalidEmaillength() {
        return new Object[][]{{5}, {4}, {33}, {34}};
    }

    public void registerNewAccount() {
        password = Utilities.generateRandomString(8);
        System.out.println(email);
        email = Utilities.generateRandomEmail(10);
        String newPID = Utilities.generateRandomString(10);
        RegisterPage registerPage = new RegisterPage();
        registerPage.gotoRegisterPage();
        Utilities.getLog();
        registerPage.testRegister(email, password, password, newPID);
    }

    @BeforeMethod
    public void beforeTest() {
        DriverManager.open();
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.afterTest();
    }
}
