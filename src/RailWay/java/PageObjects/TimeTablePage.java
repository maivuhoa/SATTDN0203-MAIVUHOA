package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage {
    //Locator
    private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");

    //Elements
    protected WebElement dynamicLocatorForTimeTable(String value) {
        return Constant.WEBDRIVER.findElement(By.xpath("//table[@class='MyTable WideTable']//td[count(//th[text()=" + "'" + value + "'" + "]/preceding-sibling::th)+1]"));
    }

    protected static WebElement dynamicLocatorForBookticket(String departFrom, String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath("//td[text()='" + departFrom + "']/following-sibling::td[text()='" + arriveAt + "']/..//a[contains(@href, 'Book')]"));
    }

    //Methods
    public String getTextInformationTimeTable(String value) {

        return dynamicLocatorForTimeTable(value).getText();
    }

    public void getLnkBookTicket() {
        dynamicLocatorForTimeTable("Book ticket").click();
    }

    public void selectDepartFromAndArrive() {
        WebElement element = dynamicLocatorForBookticket("Huế","Sài Gòn");
        Utilities.scrollIntoView(element);
        element.click();
    }

}
