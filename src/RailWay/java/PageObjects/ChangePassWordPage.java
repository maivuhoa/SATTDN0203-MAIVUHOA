package PageObjects;

import org.openqa.selenium.By;

public class ChangePassWordPage extends GeneralPage {
    //Locator
    private final By txtCurrentPassWord = By.xpath("//li[@class='current-password']/input[@id='currentPassword']");
    private final By txtNewPassWord = By.xpath("//li[@class='new-password']/input[@id='newPassword']");
    private final By txtConfirmPassWord = By.xpath("//li[@class='confirm-password']/input[@id='confirmPassword']");
    private final By btnChangePassWord = By.xpath("//p[@class='form-actions']/input[@type='submit']");
    private final By lblSuccessChangePass = By.xpath("//form[@id='ChangePW']//p[@class='message success']");
    private final By lblChangePassword = By.xpath("//h1[text()='Change password']");
}
