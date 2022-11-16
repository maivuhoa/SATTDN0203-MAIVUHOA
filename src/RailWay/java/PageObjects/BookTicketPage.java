package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import TestCases.changePassword.ChangePassWordTest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private static final Logger logger = LogManager.getLogger(ChangePassWordTest.class);
    //Locator
    private final By btnBookTicket = By.xpath("//form[@method='post']//input[@type='submit']");
    private final By lblBookTicketSuccessfully = By.xpath("//div[@id='content']//h1[@align='center']");

    //Elements
    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    protected WebElement getLblBookTicketSuccess() {
        return Constant.WEBDRIVER.findElement(lblBookTicketSuccessfully);
    }

    protected WebElement dynamicLocatorForDropDown(String elementName) {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//select[@name='" + elementName + "']"));
    }

    protected WebElement dynamicLocatorForDepartDate(String value) {
        return Constant.WEBDRIVER.findElement(By.xpath("//select[@name='Date']//option[@value='" + value + "']"));
    }

    protected WebElement dynamicLocatorForTicket(String value) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[text()=" + "'" + value + "'" + "]/preceding-sibling::th)+1]"));
    }

    //Methods
    public String getTextLblBookTicketSuccess() {
        return getLblBookTicketSuccess().getText();
    }

    public String getTextInformationTicket(String value) {
        return dynamicLocatorForTicket(value).getText();
    }

    public void selectDate(String dateDepart) {
        WebElement element = dynamicLocatorForDropDown("Date");
        Select select = new Select(element);
        select.selectByValue(dateDepart);


    }

    public String getValueDateDepart(String value) {
        return dynamicLocatorForDepartDate(value).getText();
    }

    public void selectDepartFrom(String departFrom) {
        WebElement element = dynamicLocatorForDropDown("DepartStation");
        Select select = new Select(element);
        select.selectByValue(departFrom);
    }

    public void selectArriveAt(String arriveAt) {
        WebElement element = dynamicLocatorForDropDown("ArriveStation");
        Select select = new Select(element);
        select.selectByValue(arriveAt);
    }

    public void selectSeatType(String seatType) {
        WebElement element = dynamicLocatorForDropDown("SeatType");
        Select select = new Select(element);
        select.selectByValue(seatType);
    }

    public void selectTicketAmount(String ticketAmount) {
        WebElement element = dynamicLocatorForDropDown("TicketAmount");
        Select select = new Select(element);
        select.selectByValue(ticketAmount);
    }

    public void bookTicketKetSuccess(String SelectDate, String SelectDepartFrom, String SelectArrive, String SeatType, String Amount) {
        Utilities.getLog();
        logger.info("Navigate to QA Railway Website");
        logger.info("Login with a valid account");
        selectDate(SelectDate);
        logger.info("Select a Depart date from the list");
        selectDepartFrom(SelectDepartFrom);
        logger.info("Select Sài Gòn for Depart from");
        selectArriveAt(SelectArrive);
        logger.info("Select Nha Trang for Arrive at");
        selectSeatType(SeatType);
        logger.info("Select Soft bed with air conditioner for Seat type");
        selectTicketAmount(Amount);
        logger.info("Select 1 for Ticket amount");
        Utilities.scrollIntoView(getBtnBookTicket());
        getBtnBookTicket().click();
        logger.info("Click on Book ticket button");
    }

}
