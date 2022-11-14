package Common.utilities;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz!@$";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }
    public static void getLog() {
        BasicConfigurator.configure();
    }
}
