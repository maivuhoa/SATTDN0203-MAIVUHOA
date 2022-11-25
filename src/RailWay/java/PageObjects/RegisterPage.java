package PageObjects;

import org.openqa.selenium.By;

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
    private final By lblErrorMessageForm = By.xpath("//div[@id='content']//p[@class='message error']");

}
