package PageObjects;

import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends GeneralPage {
    // Locator
    private final By lblWelComeRailWay = By.xpath("//div[@id='content']/h1[text()='Welcome to Safe Railway']");

    // Elements
    protected WebElement getLblWelComeRailWay() {
        return Constant.WEBDRIVER.findElement(lblWelComeRailWay);
    }

    //Methods
    public String getTextLblWelComeRailWay() {
        return getLblWelComeRailWay().getText();
    }

}
