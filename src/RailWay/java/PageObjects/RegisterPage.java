package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    private String email;
    private String password;
    //Locator
    private final By txtEmail = By.xpath("//li//input[@id='email']");
    private final By txtPassword = By.xpath("//li//input[@id='password']");
    private final By txtConfirmPassword = By.xpath("//li//input[@id='confirmPassword']");
    private final By txtPID = By.xpath("//li//input[@id='pid']");
    private final By btnRegister = By.xpath("//p[@class='form-actions']/input[@type='submit']");
    private final By lblRegisterSuccess = By.xpath("//div[@id='content']/p");
    private final By lblWebHostingBy = By.xpath("//center/a[@href=\"http://somee.com\"]");
    private final By lblErrorEmail = By.xpath("//label[text()='Invalid email length']");
    private final By lblErrorPassNotMatch = By.xpath("//form[@id='RegisterForm']//label[@class='validation-error']");
    private final By lblErrorMessageForm = By.xpath("//div[@id='content']//p[@class='message error']");

    //Elements
    private WebElement getTxtEmail() {
        return Constant.WEBDRIVER.findElement(txtEmail);
    }

    private WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(txtPassword);
    }

    private WebElement getTxtConfirmPassword() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassword);
    }

    private WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(txtPID);
    }

    private WebElement getLblErrorMessageForm() {
        return Constant.WEBDRIVER.findElement(lblErrorMessageForm);
    }

    private WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(btnRegister);
    }

    private WebElement getRegisterSuccessMess() {
        return Constant.WEBDRIVER.findElement(lblRegisterSuccess);
    }

    //Methods
    public void testRegister(String UserName, String Password, String ConfirmPassword, String PID) {
        getTxtEmail().sendKeys(UserName);
        getTxtPassword().sendKeys(Password);
        getTxtConfirmPassword().sendKeys(ConfirmPassword);
        getTxtPID().sendKeys(PID);
        Utilities.scrollIntoView(getBtnRegister());
        getBtnRegister().click();
    }

    public String getTextLblErrorMessageForm() {
        return getLblErrorMessageForm().getText();
    }

    public String getTextRegisterSuccessMess() {
        return getRegisterSuccessMess().getText();
    }

    public void clickBtnRegister() {
        getBtnRegister().click();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void registerNewAccount() {
        password = Utilities.generateRandomString(8);
        email = Utilities.generateRandomEmail(10);
        String newPID = Utilities.generateRandomString(10);
        RegisterPage registerPage = new RegisterPage();
        registerPage.clickRegisterTab();
        registerPage.testRegister(email, password, password, newPID);
    }

}
