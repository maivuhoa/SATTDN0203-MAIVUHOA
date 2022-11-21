package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    // Locator
    private final By lblManageTickets = By.xpath("//div[@id='content']/h1[text()='Manage Tickets']");
    private final By btnCancelTicket = By.xpath("//input[@value='Cancel']");

    // Elements

    protected WebElement getLblManageTickets() {
        return Constant.WEBDRIVER.findElement(lblManageTickets);
    }

    protected WebElement getBtnCancelButton() {
        return Constant.WEBDRIVER.findElement(btnCancelTicket);
    }

    //Methods

    public void clickBtnCancelTicket() {
        Utilities.scrollIntoView(getBtnCancelButton());
        getBtnCancelButton().click();

    }

    public String getTextManageTicket() {
        return getLblManageTickets().getText();
    }

    public void acceptOKCancel() {
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            Constant.WEBDRIVER.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
