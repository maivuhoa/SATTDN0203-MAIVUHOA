package PageObjects;

import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    // Locator
    private final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");
    private final By h1ManageTickets = By.xpath("//div[@id='content']/h1[text()='Manage Tickets']");

    // Elements
    public WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    public WebElement geth1ManageTickets() {
        return Constant.WEBDRIVER.findElement(h1ManageTickets);
    }

    //Methods
    public void gotoMyTicketPage() {
        this.getTabMyTicket().click();
    }

}
