package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.constant.Constant;

public class GeneralPage {
    //            Locator
    private final By tabHome = By.xpath("//a[@href='../']");
    private final By tabFAQ = By.xpath("//a[@href='/Page/FAQ.cshtml']");
    private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private final By tabTicketPrice = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");
    private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
    private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
    private final By lblWelComeMessage = By.xpath("//div[@class='account']/strong");
    //           Elements
    protected WebElement getTabHome() {
        return Constant.WEBDRIVER.findElement(tabHome);
    }

    protected WebElement getTabFAQ() {
        return Constant.WEBDRIVER.findElement(tabFAQ);
    }

    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    protected WebElement getTabTimeTable() {
        return Constant.WEBDRIVER.findElement(tabTimeTable);
    }

    protected WebElement getTabTicketPrice() {
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getLblWellComeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelComeMessage);
    }

    //            Method

    public void gotoRegisterPage() {
        this.getTabRegister().click();
    }
    public void gotoLoginPage(){this.getTabLogin().click();}
    public void gotoBookTicketPage(){this.getTabBookTicket().click();}

}
