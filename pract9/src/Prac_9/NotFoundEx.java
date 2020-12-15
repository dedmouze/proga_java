package Prac_9;

public class NotFoundEx extends RuntimeException {

    public NotFoundEx(){
        super("Person is not found in Base");
    }
}
