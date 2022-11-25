package PageObjects;

import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    // Locator
    private final By txtUserName = By.xpath("//input[@id='username']");
    private final By txtPassWord = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By lblLoginErrorMessage = By.xpath("//p[@class='message error LoginForm']");
    private final By lblValidationErrorEmail = By.xpath("//li[@class='username']/label[@class='validation-error']");
    private final By lblErrorMessageLogin = By.xpath("//div[@id='content']/p[@class='message error LoginForm']");
    private final By lblLoginPage = By.xpath("//div[@id='content']/h1[@align='center']");
    private final String dynamicTabMenu = "//div[@id='menu']//ul//span[text()='%s']";
    //Elements
    private WebElement getTxtUserName() {
        return Constant.WEBDRIVER.findElement(txtUserName);
    }

    private WebElement getTxtPassWord() {
        return Constant.WEBDRIVER.findElement(txtPassWord);
    }

    private WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }

    //Methods
    public void loginAccount(String username, String PassWord) {
        getTxtUserName().sendKeys(username);
        getTxtPassWord().sendKeys(PassWord);
        getBtnLogin().click();
    }

}
