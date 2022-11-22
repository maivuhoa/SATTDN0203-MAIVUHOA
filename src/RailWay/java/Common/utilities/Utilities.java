package Common.utilities;

import Common.constant.Constant;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Utilities {


    public static String getProjectPath() {
        return "@../../";
    }

    public static String generateRandomEmail(int len) {
        String domain = "@a.b";
        return generateRandomString(len - domain.length()) + domain;
    }

    public static String generateRandomString(int len) {
        return RandomStringUtils.randomAlphanumeric(len);
    }

    public static String generateRandomStringWithSpecialCharacter(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk" + "lmnopqrstuvwxyz!@$";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static void getLog() {
        BasicConfigurator.configure();
    }

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js;
        js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static String randomNumber() {
        int randomDate = 3 + (int) (Math.random() * (30 - 4) + 1);
        return Integer.toString(randomDate);
    }
}
