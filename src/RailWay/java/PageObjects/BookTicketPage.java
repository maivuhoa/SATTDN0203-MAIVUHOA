package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private final String xPathDropdown = "//div[@id='content']//select[@name='%s']";
    private final String xPathDepartDate = "//select[@name='Date']//option[@value='%s']";
    private final String xPathWideTable = "//table[@class='MyTable WideTable']//td[count(//th[text()='%s']/preceding-sibling::th)+1]";
    private final String strDepartFrom = "//div[@id='content']//select[@name='DepartStation']";
    private final String strArriveAt = "//div[@id='content']//select[@name='ArriveStation']";
    //Locator
    private final By btnBookTicket = By.xpath("//form[@method='post']//input[@type='submit']");
    private final By lblBookTicketSuccessfully = By.xpath("//div[@id='content']//h1[@align='center']");
    //Element
    private WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    private WebElement dynamicLocatorForDropDown(String value) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(xPathDropdown, value)));
    }

    private WebElement locatorDepartFrom() {
        return Constant.WEBDRIVER.findElement(By.xpath(strDepartFrom));
    }

    private WebElement locatorArriveAt() {
        return Constant.WEBDRIVER.findElement(By.xpath(strArriveAt));
    }

    //Methods
    protected String formatDepartDate(String value) {
        return String.format(xPathDepartDate, value);
    }

    protected String formatWideTable(String value) {
        return String.format(xPathWideTable, value);
    }

    public void selectDate(String dateDepart) {
        WebElement element = dynamicLocatorForDropDown("Date");
        Select select = new Select(element);
        select.selectByValue(dateDepart);
    }

    public void selectTicketInfo(String comboBoxName, String value) {
        WebElement element = dynamicLocatorForDropDown(comboBoxName);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void bookTicketKet(String SelectDate, String SelectDepartFrom, String SelectArrive, String SeatType, String Amount) {
        selectDate(SelectDate);
        selectTicketInfo("DepartStation", SelectDepartFrom);
        selectTicketInfo("ArriveStation", SelectArrive);
        selectTicketInfo("SeatType", SeatType);
        selectTicketInfo("TicketAmount", Amount);
        Utilities.scrollIntoView(getBtnBookTicket());
        getBtnBookTicket().click();
    }

}
