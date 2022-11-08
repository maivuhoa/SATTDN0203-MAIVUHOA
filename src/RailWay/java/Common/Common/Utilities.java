package Common.Common;

import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.crypto.prng.RandomGenerator;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Utilities {
    public static String getProjectPath(){
        return "@../../";
    }

    public static String generateRandomEmail(int len){
        String domain = "@a.b";
        String email = RandomStringUtils.randomAlphanumeric(len-domain.length());
        return email + domain;
    }

    public static String generateRandomString(int len){
        String email = RandomStringUtils.randomAlphanumeric(len);
        return email;
    }

    public static String generateRandomStringWithSpecialCharacter(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz!@$%#&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
}
