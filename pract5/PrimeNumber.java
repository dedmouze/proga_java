package pract5;

import java.util.Scanner;

public class PrimeNumber {
    static public boolean IsPrime(int n,int k) {
        if (n==1 || k > Math.sqrt(n))
            return true;
        if (n % k == 0)
            return false;
        return IsPrime(n,k+1);
    }

    static boolean checkPalindrome(String word) {
        if (word.length() < 2)
            return true;
        char first  = word.charAt(0);
        char last   = word.charAt(word.length()-1);
        if (first != last)
            return false;
        else
            return checkPalindrome(word.substring(1,word.length()-1));
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (IsPrime(n, 2))
            System.out.println("Yes");
        else
            System.out.println("No");
        in.close();

    }
}
