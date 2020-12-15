package Prac_9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PersonBase personBase = new PersonBase();
        Scanner sc = new Scanner(System.in);
        String textField;
        System.out.println("Write your name: ");
        String name = sc.nextLine();
        System.out.println("Write your ID: ");
        Integer ID = sc.nextInt();
        try{
            personBase.check_ID(name, ID);
        } catch (NotFoundEx err){
            System.err.println(err.getMessage());

        } catch (NotCorrectIDEx err){
            System.err.println(err.getMessage());
        }
    }
}
