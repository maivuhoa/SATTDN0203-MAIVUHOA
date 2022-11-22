package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimeTablePage extends GeneralPage {
    private String strTdText = "//td[text()='";
    private String strSiblingTdText = "']/following-sibling::td[text()='";
    private String strContainHref = "']/..//a[contains(@href, 'Book')]";
    //Locator
    private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");

    //Elements
    private WebElement dynamicLocatorForBookticket(String departFrom, String arriveAt) {
        return Constant.WEBDRIVER.findElement(By.xpath(strFormatTimeTable(departFrom, arriveAt, strTdText, strSiblingTdText, strContainHref)));
    }

    //Methods
    protected String strFormatTimeTable(String valueDepart, String valueArrive, String str1, String str2, String str3) {
        return String.format("%1$s" + valueDepart + "%2$s" + valueArrive + "%3$s", str1, str2, str3);
    }

    public void selectDepartFromAndArrive() {
        WebElement element = dynamicLocatorForBookticket("Huế", "Sài Gòn");
        Utilities.scrollIntoView(element);
        element.click();
    }

}
