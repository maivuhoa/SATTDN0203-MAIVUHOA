package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Constant.CONSTANT;

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
        return CONSTANT.WEBDRIVER.findElement(btnHome);
    }
    protected WebElement getTabFAQ(){
      return CONSTANT.WEBDRIVER.findElement(btnFAQ);

    }
   protected WebElement getTabContact(){
       return CONSTANT.WEBDRIVER.findElement(btnContact);

    }
    protected WebElement getTabTimeTable(){
      return  CONSTANT.WEBDRIVER.findElement(btnTimeTable);

    }
    protected WebElement getTabTicketPrice(){
      return  CONSTANT.WEBDRIVER.findElement(btnTicketPrice);

    }
    protected WebElement getTabBookTicket(){
      return  CONSTANT.WEBDRIVER.findElement(btnBookTicket);

    }
    protected WebElement getTabRegister(){
      return   CONSTANT.WEBDRIVER.findElement(btnRegister);

    }
    protected WebElement getTabLogin(){
     return  CONSTANT.WEBDRIVER.findElement(btnLogin);

    }
    protected WebElement getTxtWellComeMes(){
        return CONSTANT.WEBDRIVER.findElement(txtWelComeMes);

    }
    //            Method

    public void  gotoLoginPage(){
        this.getTabLogin().click();

    }
    public void gotoRegisterPage(){
        this.getTabRegister().click();
    }
}
