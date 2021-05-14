package regularexpression;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    private static final String IPADDRESS_PATTERN =
            "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    private static final String DATA_PATTERN ="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\" +
            "1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\" +
            "d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\" +
            "d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\" +
            "d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String s1 = s.next();
        outputIP(s1);
        outputData(s1);
    }

    public static boolean validateIP( String ip){
        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static boolean validateDate( String ip){
        Pattern pattern = Pattern.compile(DATA_PATTERN);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static void outputIP(String s1) {
        boolean bool = validateIP(s1);
        if(bool) {
            System.out.println("Строка является IP адресом");
        }
        else {
            System.out.println("Строка не является IP адресом");
        }
    }

    public static void outputData(String s1) {
        boolean bool = validateDate(s1);
        if(bool) {
            System.out.println("Дата соответствует формату");
        }
        else {
            System.out.println("Дата не соответствует формату");
        }
    }
}