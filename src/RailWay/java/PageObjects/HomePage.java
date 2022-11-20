package PageObjects;

import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    // Locator
    private final By tabHome = By.xpath("//li[@class='selected']/a[@href='../']");
    private final By lblWellComeRailWay = By.xpath("//div[@id='content']/h1[text()='Welcome to Safe Railway']");

    // Elements
    public WebElement geth1WellComeRailWay() {
        return Constant.WEBDRIVER.findElement(lblWellComeRailWay);
    }

}
