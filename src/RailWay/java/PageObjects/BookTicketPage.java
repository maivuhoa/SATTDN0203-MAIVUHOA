package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    private String strXPathSelectDropdown = "//div[@id='content']//select[@name='";
    private String strEndString = "']";
    private String strDepartDate = "//select[@name='Date']//option[@value='";
    private String strWideTable = "//table[@class='MyTable WideTable']//td[count(//th[text()='";
    private String strWideTableSibling = "']/preceding-sibling::th)+1]";
    private String strDepartFrom = "//div[@id='content']//select[@name='DepartStation']";
    private String strArriveAt = "//div[@id='content']//select[@name='ArriveStation']";
    //Locator
    private final By btnBookTicket = By.xpath("//form[@method='post']//input[@type='submit']");
    private final By lblBookTicketSuccessfully = By.xpath("//div[@id='content']//h1[@align='center']");

    //Elements
    private WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    private WebElement getLblBookTicketSuccess() {
        return Constant.WEBDRIVER.findElement(lblBookTicketSuccessfully);
    }

    private WebElement dynamicLocatorForDropDown(String value) {
        return Constant.WEBDRIVER.findElement(By.xpath(strFormat(value, strXPathSelectDropdown, strEndString)));
    }

    private WebElement dynamicLocatorForDepartDate(String value) {
        return Constant.WEBDRIVER.findElement(By.xpath(strFormat(value, strDepartDate, strEndString)));
    }

    private WebElement dynamicLocatorForTicket(String value) {
        return Constant.WEBDRIVER.findElement(By.xpath(strFormat(value, strWideTable, strWideTableSibling)));
    }

    private WebElement dynamicLocatorDepartFrom() {
        return Constant.WEBDRIVER.findElement(By.xpath(strDepartFrom));
    }

    private WebElement dynamicLocatorArriveAt() {
        return Constant.WEBDRIVER.findElement(By.xpath(strArriveAt));
    }

    //Methods
    protected String strFormat(String value, String str1, String str2) {
        return String.format("%1$s" + value + "%2$s", str1, str2);
    }

    public WebElement getElementBtnBookTicket() {
        return getBtnBookTicket();
    }

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
        selectDate(SelectDate);
        selectTicketInfo("DepartStation", SelectDepartFrom);
        selectTicketInfo("ArriveStation", SelectArrive);
        selectTicketInfo("SeatType", SeatType);
        selectTicketInfo("TicketAmount", Amount);
        Utilities.scrollIntoView(getBtnBookTicket());
        getBtnBookTicket().click();
    }
}
