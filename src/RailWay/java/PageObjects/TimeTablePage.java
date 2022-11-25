package PageObjects;

import org.openqa.selenium.By;

public class TimeTablePage extends GeneralPage {
    private final String strTimeTable = "//td[text()='%s']/following-sibling::td[text()='%s']/..//a[contains(@href, 'Book')]";
    //Locator
    private final By tabTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");

}
