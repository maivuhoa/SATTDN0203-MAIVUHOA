package PageObjects;

import org.openqa.selenium.By;

public class BookTicketPage extends GeneralPage {
    private final String xPathDropdown = "//div[@id='content']//select[@name='%s']";
    private final String xPathDepartDate = "//select[@name='Date']//option[@value='%s']";
    private final String xPathWideTable = "//table[@class='MyTable WideTable']//td[count(//th[text()='%s']/preceding-sibling::th)+1]";
    private final String strDepartFrom = "//div[@id='content']//select[@name='DepartStation']";
    private final String strArriveAt = "//div[@id='content']//select[@name='ArriveStation']";
    //Locator
    private final By btnBookTicket = By.xpath("//form[@method='post']//input[@type='submit']");
    private final By lblBookTicketSuccessfully = By.xpath("//div[@id='content']//h1[@align='center']");

}
