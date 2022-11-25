package PageObjects;

import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage extends GeneralPage {
    // Locator
    private final String xPathDropdownFilter = "//table//tbody//select[@name='%s']";
    private final By xPathDepartStation = By.xpath("//table[@class='MyTable']//td[count(//th[text()='Depart Station']/preceding-sibling::th)+1]");
    private final By btnFilterApply = By.xpath("//div[@class='Filter']//input[@type='submit']");
    private final By txtDepartDate = By.xpath("//input[@name='FilterDpDate']");

    //Element
    private WebElement getBtnFilterApply() {
        return Constant.WEBDRIVER.findElement(btnFilterApply);
    }

    private WebElement getTxtDepartDate() {
        return Constant.WEBDRIVER.findElement(txtDepartDate);
    }

    private WebElement getDepartStation() {
        return Constant.WEBDRIVER.findElement(xPathDepartStation);
    }

    private WebElement dynamicLocatorForFilter(String value) {
        return Constant.WEBDRIVER.findElement(By.xpath(String.format(xPathDropdownFilter, value)));
    }
    //Method

    public String selectDepartStation(String dateDepart) {
        WebElement element = dynamicLocatorForFilter("FilterDpStation");
        Select select = new Select(element);
        select.selectByValue(dateDepart);
        return select.getFirstSelectedOption().getText();
    }

    public void clickBtnFilter() {
        getBtnFilterApply().click();
    }

    public String getValueDepartStationinTable() {
        return getDepartStation().getText();
    }

    public String getTextDepartStation() {
        WebElement element = dynamicLocatorForFilter("FilterDpStation");
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public void  getTextDepart(String date) {
        getTxtDepartDate().sendKeys(date);
    }
}
