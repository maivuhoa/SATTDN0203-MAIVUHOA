package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage {
    // Locator
    private String strBtnCancel = "//table[@class='MyTable']//input[contains(@onclick,'%s')]";

    private final By lblManageTickets = By.xpath("//div[@id='content']/h1[text()='Manage Tickets']");

    // Elements

    private WebElement getLblManageTickets() {
        return Constant.WEBDRIVER.findElement(lblManageTickets);
    }

    private WebElement getBtnCancelButton(String id) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(strBtnCancel, id)));
    }
    //Methods

    public void clickBtnCancelTicket(String id) {
        Utilities.scrollIntoView(getBtnCancelButton(id));
        getBtnCancelButton(id).click();
    }

    public String getTextManageTicket() {
        return getLblManageTickets().getText();
    }

    public void acceptOKCancel() {
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public boolean isElementPresent(String id) {
        try {
            getBtnCancelButton(id);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

}
