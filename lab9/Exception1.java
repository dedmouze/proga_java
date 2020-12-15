package Lab_9;

import java.util.Scanner;

public class Exception1 {
    public void exceptionDemo() {
        try{
            Scanner myScanner = new Scanner( System.in );
            System.out.print( "Enter an integer ");
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println( 2 / i );
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{
            System.out.println("Исключение обработано");
        }
        ThrowsDemo td = new ThrowsDemo();
        td.printMessage(null);

    }
}
