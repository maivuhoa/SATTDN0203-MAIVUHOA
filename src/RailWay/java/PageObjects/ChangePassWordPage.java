package PageObjects;

import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePassWordPage extends GeneralPage {
    //Locator
    private final By tabChangePassWord = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private final By txtCurrentPassWord = By.xpath("//li[@class='current-password']/input[@id='currentPassword']");
    private final By txtNewPassWord = By.xpath("//li[@class='new-password']/input[@id='newPassword']");
    private final By txtConfirmPassWord = By.xpath("//li[@class='confirm-password']/input[@id='confirmPassword']");
    private final By btnChangePassWord = By.xpath("//p[@class='form-actions']/input[@type='submit']");
    private final By lblSuccessChangePass = By.xpath("//form[@id='ChangePW']//p[@class='message success']");
    private final By lblChangePassword = By.xpath("//h1[text()='Change password']");

    //Elements
    public WebElement getTabChangePassWord() {
        return Constant.WEBDRIVER.findElement(tabChangePassWord);
    }

    public WebElement getTxtCurrentPassWord() {
        return Constant.WEBDRIVER.findElement(txtCurrentPassWord);
    }

    public WebElement getTxtNewPassWord() {
        return Constant.WEBDRIVER.findElement(txtNewPassWord);
    }

    public WebElement getTxtConfirmPassWord() {
        return Constant.WEBDRIVER.findElement(txtConfirmPassWord);
    }

    public WebElement getBtnChangePassWord() {
        return Constant.WEBDRIVER.findElement(btnChangePassWord);
    }

    public WebElement getMessageSuccessChangePass() {
        return Constant.WEBDRIVER.findElement(lblSuccessChangePass);
    }

    public WebElement getLblChangePassword() {
        return Constant.WEBDRIVER.findElement(lblChangePassword);
    }

    //Methods
    public void gotoTabChangePassWord() {
        getTabChangePassWord().click();
    }

    public void changePass(String currentPass, String newPass, String confirmPass) {
        getTxtCurrentPassWord().sendKeys(currentPass);
        getTxtNewPassWord().sendKeys(newPass);
        getTxtConfirmPassWord().sendKeys(confirmPass);
        getBtnChangePassWord().click();
    }

}
