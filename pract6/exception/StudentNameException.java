package pract9.exception;

public class StudentNameException extends Exception{
    public StudentNameException() { super("Invalid name."); }
    public StudentNameException(String message) { super("Invalid name. Message: '" + message + " '."); };
}
