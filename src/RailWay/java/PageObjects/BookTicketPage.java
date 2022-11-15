package PageObjects;

import Common.constant.Constant;
import Common.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import PageObjects.GeneralPage;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage {
    //Locator
    private final By btnBookTicket = By.xpath("//form[@method='post']//input[@type='submit']");

    //Elements
    protected WebElement getBtnBookTicket() {
        return Constant.WEBDRIVER.findElement(btnBookTicket);
    }

    //Methods
    public WebElement dynamicLocator(String elementName) {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//select[@name='" + elementName + "']"));
    }
    public void selectDate(){
       WebElement element= dynamicLocator("Date");
        Select select = new Select(element);
        select.selectByValue(Utilities.randomNumber());
    }
    public void selectDepartFrom(){
        WebElement element=dynamicLocator("DepartStation");
        Select select=new Select(element);
        select.selectByValue("1");
    }
    public void selectArriveAt(){
        WebElement element=dynamicLocator("ArriveStation");
        Select select=new Select(element);
        select.selectByValue("3");
    }
    public void selectSeatType(){
        WebElement element=dynamicLocator("SeatType");
        Select select=new Select(element);
        select.selectByValue("6");
    }
    public void selectTicketAmount(){
        WebElement element=dynamicLocator("TicketAmount");
        Select select=new Select(element);
        select.selectByValue("1");
    }

}
