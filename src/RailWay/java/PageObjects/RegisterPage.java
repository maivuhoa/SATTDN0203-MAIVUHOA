package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //Locator
    private final By inpEmail = By.xpath("//li//input[@id='email']");
    private final By inpPassword = By.xpath("//li//input[@id='password']");
    private final By inpConfirmPassword = By.xpath("//li//input[@id='confirmPassword']");
    private final By inpPID = By.xpath("//li//input[@id='pid']");
    private final By btnRegister = By.xpath("//p[@class='form-actions']/input[@type='submit']");
    private final By lblRegisterSuccess = By.xpath("//div[@id='content']/p");
    private final By lblWebHostingBy = By.xpath("//center/a[@href=\"http://somee.com\"]");
    private final By lblErrorEmail = By.xpath("//label[text()='Invalid email length']");
    private final By lblErrorPassNotMatch = By.xpath("//form[@id='RegisterForm']//label[@class='validation-error']");
    private final By paErrorMessageForm = By.xpath("//div[@id='content']//p[@class='message error']");

    //Elements
    public WebElement getInpEmail() {
        return Constant.WEBDRIVER.findElement(inpEmail);
    }

    public WebElement getInpPassword() {
        return Constant.WEBDRIVER.findElement(inpPassword);
    }

    public WebElement getInpConfirmPassword() {
        return Constant.WEBDRIVER.findElement(inpConfirmPassword);
    }

    public WebElement getInpPID() {
        return Constant.WEBDRIVER.findElement(inpPID);
    }

    public WebElement getlblErrorPassNotMatch() {
        return Constant.WEBDRIVER.findElement(lblErrorPassNotMatch);
    }

    public WebElement getpaErrorMessageForm() {
        return Constant.WEBDRIVER.findElement(paErrorMessageForm);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    public WebElement getLblErrorEmail() {
        return Constant.WEBDRIVER.findElement(lblErrorEmail);
    }

    public WebElement getRegisterSuccessMess() {
        return Constant.WEBDRIVER.findElement(lblRegisterSuccess);
    }

    public WebElement getLblWebHostingBy() {
        return Constant.WEBDRIVER.findElement(lblWebHostingBy);
    }

    //Methods
    JavascriptExecutor js;

    public void testRegister(String UserName, String Password, String ConfirmPassword, String PID) {
        getInpEmail().sendKeys(UserName);
        getInpPassword().sendKeys(Password);
        getInpConfirmPassword().sendKeys(ConfirmPassword);
        getInpPID().sendKeys(PID);
        Utilities.scrollIntoView(getBtnRegister());
        getBtnRegister().click();
    }

}
