package PageObjects;

import Common.Constant.CONSTANT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {
    // Locator
    private final By userName = By.xpath("//input[@id='username']");
    private final By passWord = By.xpath("//input[@id='password']");
    private final By btnLogin = By.xpath("//input[@value='Login']");
    private final By txtLoginErrorMes = By.xpath("//p[@class='message error LoginForm']");

    private final By stWelcomeText = By.xpath("//div[@class='account']/strong");

    private final By paErorrMessageLogin = By.xpath("//div[@id='content']/p[contains(@class,'error LoginForm')]");

    public WebElement getWellComeMes() {
        return getTxtWellComeMes();
    }

    public WebElement getTxtUserName() {
        return CONSTANT.WEBDRIVER.findElement(userName);
    }

    public WebElement getTxtPassWord() {
        return CONSTANT.WEBDRIVER.findElement(passWord);
    }

    public WebElement
    getBtnLogin() {
        return CONSTANT.WEBDRIVER.findElement(btnLogin);
    }

    public WebElement getTabLogin() {
        return super.getTabLogin();
    }

    public WebElement getErrorMessageLogin() {
        return CONSTANT.WEBDRIVER.findElement(paErorrMessageLogin);
    }

    public WebElement getTxtMessError() {
        return CONSTANT.WEBDRIVER.findElement(txtLoginErrorMes);
    }

    //  Methods
    public void testLogin(String username, String PassWord) {
        getTxtUserName().sendKeys(username);
        getTxtPassWord().sendKeys(PassWord);
        getBtnLogin().click();
    }

}
