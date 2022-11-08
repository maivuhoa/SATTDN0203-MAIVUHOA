package PageObjects;
import Common.Constant.CONSTANT;

public class HomePage extends GeneralPage{
   public void  open(){
       CONSTANT.WEBDRIVER.navigate().to(CONSTANT.RailwayURL);
   }

}
