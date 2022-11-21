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
    private String strXPathSelectDropdown = "//div[@id='content']//select[@name='";
    private String strDepartDate = "//select[@name='Date']//option[@value='";
    private String strWideTable = "//table[@class='MyTable WideTable']//td[count(//th[text()='";
    private String strWideTableSibling = "']/preceding-sibling::th)+1]";
    private String strDepartFrom = "//div[@id='content']//select[@name='DepartStation']";
    private String strArriveAt = "//div[@id='content']//select[@name='ArriveStation']";
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
        return Constant.WEBDRIVER.findElement(By.xpath(strXPathSelectDropdown + elementName + "']"));
    }

    protected WebElement dynamicLocatorForDepartDate(String value) {
        return Constant.WEBDRIVER.findElement(By.xpath(strDepartDate + value + "']"));
    }

    protected WebElement dynamicLocatorForTicket(String value) {
        return Constant.WEBDRIVER.findElement(By.xpath(strWideTable + value + strWideTableSibling));
    }

    protected WebElement dynamicLocatorDepartFrom() {
        return Constant.WEBDRIVER.findElement(By.xpath(strDepartFrom));
    }

    protected WebElement dynamicLocatorArriveAt() {
        return Constant.WEBDRIVER.findElement(By.xpath(strArriveAt));
    }

    public WebElement getElementBtnBookTicket() {
        return getBtnBookTicket();
    }

    //Methods
    public String getTextLblBookTicketSuccess() {
        return getLblBookTicketSuccess().getText();
    }

    public String getTextInformationTicket(String value) {
        return dynamicLocatorForTicket(value).getText();
    }

    public Select getValueDepartFrom() {
        return new Select(dynamicLocatorDepartFrom());
    }

    public Select getValueArriveAt() {
        return new Select(dynamicLocatorArriveAt());
    }

    public String getSelectedDepartFrom() {
        return getValueDepartFrom().getFirstSelectedOption().getText();
    }

    public String getSelectedArriveAt() {
        return getValueArriveAt().getFirstSelectedOption().getText();
    }

    public String getValueDateDepart(String value) {
        return dynamicLocatorForDepartDate(value).getText();
    }


    public void selectDate(String dateDepart) {
        WebElement element = dynamicLocatorForDropDown("Date");
        Select select = new Select(element);
        select.selectByValue(dateDepart);
    }

    public void selectTicketInfo(String comboBoxName, String Value) {
        WebElement element = dynamicLocatorForDropDown(comboBoxName);
        Select select = new Select(element);
        select.selectByVisibleText(Value);
    }

    public void bookTicketKetSuccess(String SelectDate, String SelectDepartFrom, String SelectArrive, String SeatType, String Amount) {
        final Logger logger = LogManager.getLogger(ChangePassWordTest.class);

        Utilities.getLog();
        logger.info("Navigate to QA Railway Website");
        logger.info("Login with a valid account");
        selectDate(SelectDate);
        logger.info("Select a Depart date from the list");
        selectTicketInfo("DepartStation", SelectDepartFrom);
        logger.info("Select Sài Gòn for Depart from");
        selectTicketInfo("ArriveStation", SelectArrive);
        logger.info("Select Nha Trang for Arrive at");
        selectTicketInfo("SeatType", SeatType);
        logger.info("Select Soft bed with air conditioner for Seat type");
        selectTicketInfo("TicketAmount", Amount);
        logger.info("Select 1 for Ticket amount");
        Utilities.scrollIntoView(getBtnBookTicket());
        getBtnBookTicket().click();
        logger.info("Click on Book ticket button");
    }
}
