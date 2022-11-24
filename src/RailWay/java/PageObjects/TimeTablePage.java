package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage {
    private final String strTimeTable = "//td[text()='%s']/following-sibling::td[text()='%s']/..//a[contains(@href, 'Book')]";
    //Locator
    private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");

    //Elements
    private WebElement dynamicLocatorForBookticket(String departFrom, String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath(strFormatTimeTable(departFrom, arriveAt)));
    }

    //Methods
    protected String strFormatTimeTable(String valueDepart, String valueArrive) {
        return String.format(strTimeTable, valueDepart, valueArrive);
    }

    public void selectDepartFromAndArrive() {
        WebElement element = dynamicLocatorForBookticket("Huế", "Sài Gòn");
        Utilities.scrollIntoView(element);
        element.click();
    }

}
