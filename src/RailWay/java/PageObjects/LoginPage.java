package PageObjects;

import org.openqa.selenium.By;

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

}
