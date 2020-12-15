package Lab_16;

public final class Dish extends MenuItem{

    public Dish(String name, String description){
        super(name, description, 0);
    }

    public Dish(String name, String description, int cost ){
        super(name, description, cost);
    }
}
