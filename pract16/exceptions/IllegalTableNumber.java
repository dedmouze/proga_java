package pract15.exceptions;

public class IllegalTableNumber extends RuntimeException {
    public IllegalTableNumber(String message) {
        super(message);
    }
    public IllegalTableNumber(int n) {
        super("Illegal table number: " + n + ".");
    }
}
