package PageObjects;

import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locator
    private final By tabHome = By.xpath("//a[@href='../']");
    private final By tabFAQ = By.xpath("//a[@href='/Page/FAQ.cshtml']");
    private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private final By tabTicketPrice = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");
    private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    private final By lblWelComeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassWord = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
    private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");

    //Elements
    private WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }

    private WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    private WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    private WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    private WebElement getLblWellComeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelComeMessage);
    }

    private WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    private WebElement getTabChangePassWord() {
        return Constant.WEBDRIVER.findElement(tabChangePassWord);
    }

    private WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    //Methods
    public void clickRegisterTab() {
        getTabRegister().click();
    }

    public void clickLoginTab() {
        getTabLogin().click();
    }

    public void clickLogoutTab() {
        getTabLogout().click();
    }

    public void clickBookTicketTab() {
        getTabBookTicket().click();
    }

    public void clickTimeTableTab() {
        getTabTimeTable().click();
    }

    public void clickMyTicketTab() {
        getTabMyTicket().click();
    }

    public void clickChangePassWordTab() {
        getTabChangePassWord().click();
    }

    public String getTextWelcomeMessage() {
        return getLblWellComeMessage().getText();
    }
}
