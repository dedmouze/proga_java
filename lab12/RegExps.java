package lab12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExps {
    //Task 1
    void getPrice(String string) {
        Matcher m = Pattern.compile("(?:^|[^\\w\\d.])([1-9]\\d*(?:.\\d{0,2})?\\s*(?:USD|EU|RUB))")
                .matcher(string);
        while (m.find()) {
            String matched= m.group(1);
            System.out.println(matched);
        }
    }
    //Task 2
    boolean hasPlus(String string) {
        Matcher m = Pattern.compile("([0-9]{1,9} \\+)").matcher(string);
        return m.find();
    }
    //Task 3
    boolean isData(String s){
        return s.matches("(0[1-9]|1[0-9]|2[0-9]|3[0-1])\\/(0[1-9]|1[0-2])\\/(19[0-8][0-9]|199[0-9]|[2-9][0-9]{3})");
    }
    // Task 4
    boolean isEmail(String s) {
        return s.matches("[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)?");
    }

    public static void main(String[] args) {

        RegExps regExps = new RegExps();
        regExps.getPrice("TEST 25.98 USD, 155.10 RUB, 99.50 EU");
        regExps.getPrice("TEST 25.98 $, 155.10 RU, 99.50 ERR");
        System.out.println(regExps.hasPlus("2 + 2"));
        System.out.println(regExps.hasPlus("2 / 2"));
        System.out.println(regExps.isData("29/02/2000"));
        System.out.println(regExps.isData("1/1/1899"));
        System.out.println(regExps.isEmail("test@mail.ru"));
        System.out.println(regExps.isEmail("testerror%%ru"));
    }
}
