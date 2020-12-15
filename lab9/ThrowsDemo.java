package Lab_9;

public class ThrowsDemo {
    public void printMessage(String key) {
        try{
            String message = getDetails(key);
            System.out.println( message );
        }catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("Исключение обработано");
        }
    }

    public String getDetails(String key) throws NullPointerException{
        if(key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for" + key;
    }
}
