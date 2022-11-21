package PageObjects;

import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePassWordPage extends GeneralPage {
    //Locator
    private final By txtCurrentPassWord = By.xpath("//li[@class='current-password']/input[@id='currentPassword']");
    private final By txtNewPassWord = By.xpath("//li[@class='new-password']/input[@id='newPassword']");
    private final By txtConfirmPassWord = By.xpath("//li[@class='confirm-password']/input[@id='confirmPassword']");
    private final By btnChangePassWord = By.xpath("//p[@class='form-actions']/input[@type='submit']");
    private final By lblSuccessChangePass = By.xpath("//form[@id='ChangePW']//p[@class='message success']");
    private final By lblChangePassword = By.xpath("//h1[text()='Change password']");

    //Elements
    protected WebElement getTxtCurrentPassWord() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassWord);
    }

    protected WebElement getTxtNewPassWord() {
        return Constant.WEBDRIVER.findElement(txtNewPassWord);
    }

    protected WebElement getTxtConfirmPassWord() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassWord);
    }

    protected WebElement getBtnChangePassWord() {
        return Constant.WEBDRIVER.findElement(btnChangePassWord);
    }

    protected WebElement getMessageSuccessChangePass() {
        return Constant.WEBDRIVER.findElement(lblSuccessChangePass);
    }

    protected WebElement getLblChangePassword() {
        return Constant.WEBDRIVER.findElement(lblChangePassword);
    }

    //Methods
    public String getTextChangePassSuccess() {
        return getMessageSuccessChangePass().getText();
    }

    public String getTextLblChangePassWord() {
        return getLblChangePassword().getText();
    }

    public void changePass(String currentPass, String newPass, String confirmPass) {
        getTxtCurrentPassWord().sendKeys(currentPass);
        getTxtNewPassWord().sendKeys(newPass);
        getTxtConfirmPassWord().sendKeys(confirmPass);
        getBtnChangePassWord().click();
    }

}
