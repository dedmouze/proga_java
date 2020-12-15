package Lab_16;

public class MenuItem {
    private int cost;
    private String name;
    private String description;

    public MenuItem (String name, String description, int cost){
        if ((cost<0) || (name=="") || (description=="") || (description==null) || (name==null)){
            throw new java.lang.IllegalArgumentException();
        }
        this.cost=cost;
        this.description=description;
        this.name=name;
    }
    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
