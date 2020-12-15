package pract15.menu;

import pract15.interfaces.Item;

public class MenuItem implements Item, Comparable<MenuItem>{
    protected int cost;
    protected String name;
    protected String description;

    public int getCost() {
        return cost;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(MenuItem o) {
        return getName().compareTo(o.getName());
    }
}
