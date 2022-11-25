package PageObjects;

import org.openqa.selenium.By;

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

}
