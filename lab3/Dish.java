public abstract class Dish {
    private String name;
    private String material;
    private int price;

    public Dish(String name, String material, int price){
        this.name = name;
        this.material = material;
        this.price = price;
    }

    public abstract void infoDish();

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getMaterial() { return material; }

    public void setMaterial(String material) { this.material = material; }
    public void setPrice(int price) { this.price = price; }
    public void setName(String name) { this.name = name; }
}
