package PageObjects;

import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    // Locator
    private final By userName = By.xpath("//input[@id='username']");
    private final By passWord = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By txtLoginErrorMes = By.xpath("//p[@class='message error LoginForm']");
    private final By msgErrorMessageLogin = By.xpath("//div[@id='content']/p[contains(@class,'error LoginForm')]");
    private final By lblValidationErrorEmail = By.xpath("//li[@class='username']/label[@class='validation-error']");
    private final By pErrorMessageLogin = By.xpath("//div[@id='content']/p[@class='message error LoginForm']");
    private final By txtLoginPage = By.xpath("//div[@id='content']/h1[@align='center']");

    // Elements
    public WebElement getTxtUserName() {
        return Constant.WEBDRIVER.findElement(userName);
    }

    public WebElement getTxtPassWord() {
        return Constant.WEBDRIVER.findElement(passWord);
    }

    public WebElement getBtnLogin() {
        return Constant.WEBDRIVER.findElement(btnLogin);
    }


    public WebElement getErrorMessageLogin() {
        return Constant.WEBDRIVER.findElement(msgErrorMessageLogin);
    }

    public WebElement getTxtMessError() {
        return Constant.WEBDRIVER.findElement(txtLoginErrorMes);
    }

    public WebElement getLblValidationErrorEmail() {
        return Constant.WEBDRIVER.findElement(lblValidationErrorEmail);
    }

    public WebElement getPErrorMessageLogin() {
        return Constant.WEBDRIVER.findElement(pErrorMessageLogin);
    }

    public WebElement getTxtLoginPage() {
        return Constant.WEBDRIVER.findElement(txtLoginPage);
    }

    //  Methods
    public void testLogin(String username, String PassWord) {
        getTxtUserName().sendKeys(username);
        getTxtPassWord().sendKeys(PassWord);
        getBtnLogin().click();
    }

    public WebElement getWellComeMes() {
        return getLblWellComeMessage();
    }

    public WebElement getTabLogin() {
        return super.getTabLogin();
    }

}
