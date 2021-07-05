package utils;

//import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    public static String RandString(int keyLength)
    {
        return RandomStringUtils.randomAlphabetic(keyLength);
    }

    public static String RandomTelNumberRu()
    {
        return "+7999" + RandomStringUtils.randomNumeric(7);

    }

    public static String RandEmail()
    {
        return RandString(10)+'@'+RandString(5)+".com";
    }

}
