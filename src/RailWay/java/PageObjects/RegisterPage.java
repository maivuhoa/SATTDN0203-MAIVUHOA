package PageObjects;
import Common.Constant.CONSTANT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class RegisterPage extends GeneralPage{
    //Locator
    JavascriptExecutor js;
    private final By inpEmail=By.xpath("//li//input[@id='email']");
    private final By inpPassword=By.xpath("//li//input[@id='password']");
    private final By inpConfirmPassword=By.xpath("//li//input[@id='confirmPassword']");
    private final By inpPID=By.xpath("//li//input[@id='pid']");
    private final By btnRegister=By.xpath("//p[@class='form-actions']/input[@type='submit']");
    private final By lblRegisterSuccess=By.xpath("//div[@id='content']/p");
    private final By lblWebHostingBy=By.xpath("//center/a[@href=\"http://somee.com\"]");
    private final By lblErrorEmail=By.xpath("//label[text()='Invalid email length']");
    //Elements
    public WebElement getInpEmail(){
        return CONSTANT.WEBDRIVER.findElement(inpEmail);
    }
    public WebElement getInpPassword(){
        return CONSTANT.WEBDRIVER.findElement(inpPassword);
    }
    public WebElement getInpConfirmPassword(){
        return CONSTANT.WEBDRIVER.findElement(inpConfirmPassword);
    }
    public WebElement getInpPID(){
        return CONSTANT.WEBDRIVER.findElement(inpPID);
    }
    public WebElement getBtnRegister(){
        return CONSTANT.WEBDRIVER.findElement(btnRegister);
    }
    public WebElement getLblErrorEmail(){return CONSTANT.WEBDRIVER.findElement(lblErrorEmail);}
    public WebElement getRegisterSuccessMess(){ return CONSTANT.WEBDRIVER.findElement(lblRegisterSuccess);}
    public WebElement getLblWebHostingBy(){return CONSTANT.WEBDRIVER.findElement(lblWebHostingBy);}
    //Methods

    public void testRegister(String UserName,String Password,String ConfirmPassword,String PID){
        getInpEmail().sendKeys(UserName);
        getInpPassword().sendKeys(Password);
        getInpConfirmPassword().sendKeys(ConfirmPassword);
        getInpPID().sendKeys(PID);
        js.executeScript("arguments[0].click();",getBtnRegister());
    }

    public RegisterPage(WebDriver driver){
        js = (JavascriptExecutor) driver;
    }
}
