package PageObjects;

import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    // Locator
    private final By lblWellComeRailWay = By.xpath("//div[@id='content']/h1[text()='Welcome to Safe Railway']");

    // Elements
    protected WebElement getLblWellComeRailWay() {
        return Constant.WEBDRIVER.findElement(lblWellComeRailWay);
    }

    //Methods
    public String getTextLblWellComeRailWay() {
        return getLblWellComeRailWay().getText();
    }

}
