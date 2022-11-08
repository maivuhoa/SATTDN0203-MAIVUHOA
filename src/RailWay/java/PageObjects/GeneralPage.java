package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Constant.Constant;

public class GeneralPage {
    //            Locator
    private final By btnHome = By.xpath("//a[@href='../']");
    private final By btnFAQ = By.xpath("//a[@href='/Page/FAQ.cshtml']");
    private final By btnContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
    private final By btnTimeTable = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private final By btnTicketPrice=By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");
    private final By btnBookTicket=By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private final   By btnRegister=By.xpath("//a[@href='/Account/Register.cshtml']");
    private final  By btnLogin=By.xpath("//a[@href='/Account/Login.cshtml']");
    private final By txtWelComeMes=By.xpath("//div[@class='account']/strong");
    //           Elements
    protected WebElement getTabHome(){
        return Constant.WEBDRIVER.findElement(btnHome);
    }
    protected WebElement getTabFAQ(){
      return Constant.WEBDRIVER.findElement(btnFAQ);

    }
   protected WebElement getTabContact(){
       return Constant.WEBDRIVER.findElement(btnContact);

    }
    protected WebElement getTabTimeTable(){
      return  Constant.WEBDRIVER.findElement(btnTimeTable);

    }
    protected WebElement getTabTicketPrice(){
      return  Constant.WEBDRIVER.findElement(btnTicketPrice);

    }
    protected WebElement getTabBookTicket(){
      return  Constant.WEBDRIVER.findElement(btnBookTicket);

    }
    protected WebElement getTabRegister(){
      return   Constant.WEBDRIVER.findElement(btnRegister);

    }
    protected WebElement getTabLogin(){
     return  Constant.WEBDRIVER.findElement(btnLogin);

    }
    protected WebElement getTxtWellComeMes(){
        return Constant.WEBDRIVER.findElement(txtWelComeMes);

    }
    //            Method

    public void  gotoLoginPage(){
        this.getTabLogin().click();

    }
}
