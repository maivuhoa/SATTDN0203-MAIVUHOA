package PageObjects;
import Common.Constant.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends GeneralPage{
   public void  open(){
       Constant.WEBDRIVER.navigate().to(Constant.RailwayURL);
   }

}
