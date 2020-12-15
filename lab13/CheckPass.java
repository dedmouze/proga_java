package lab13;

import java.util.Scanner;
import java.util.regex.Pattern;


public class CheckPass {

    private static final String[] passwordReg = new String[] {".{8,}", "[A-Z]", "[a-z]", "[0-9]",};

    public static boolean PasswordIsSecure(String password) {
        for (String passReg : passwordReg)
            if (!Pattern.compile(passReg).matcher(password).find())
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter password: ");
            var password = scanner.nextLine();

            if (CheckPass.PasswordIsSecure(password)) {
                System.out.println("Your password is secure.");
                return;
            }
            else {
                System.out.println("Your password is not secure.");
            }
        }
    }
}
