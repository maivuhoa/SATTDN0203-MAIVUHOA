package PageObjects;

import org.openqa.selenium.By;

public class MyTicketPage extends GeneralPage {
    // Locator
    private final String strBtnCancel = "//table[@class='MyTable']//input[contains(@onclick,'%s')]";

    private final By lblManageTickets = By.xpath("//div[@id='content']/h1[text()='Manage Tickets']");

}
