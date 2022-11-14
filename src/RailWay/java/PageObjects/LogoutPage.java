package PageObjects;
import Common.constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class LogoutPage extends GeneralPage{
    // Locator
    private final By tabLogout=By.xpath("//a[@href='/Account/Logout']");
    // Elements
    public WebElement getTabLogout(){return Constant.WEBDRIVER.findElement(tabLogout);}
    // Methods
    public void gotoTabLogout(){this.getTabLogout().click();}
}
