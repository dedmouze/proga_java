public class Knife extends Dish implements Priceable {
    private int sharpness;

    public Knife(String name, String material, int price, int sharpness){
        super(name, material, price);
        this.sharpness = sharpness;
    }

    public void infoDish(){
        System.out.println("Название: " + super.getName()
                + " Материал: " + super.getMaterial()
                + " Цена: " + super.getPrice()
                + " Острота ножа: " + sharpness);
    }

    public int getPrice() {
        return super.getPrice();
    }
}
