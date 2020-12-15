public class Service extends Dish implements Priceable {
    private int amount;

    public Service(String name, String material, int price, int amount){
        super(name, material, price);
        this.amount = amount;
    }

    public void infoDish(){
        System.out.println("Название: " + super.getName()
                            + " Материал: " + super.getMaterial()
                            + " Цена: " + super.getPrice()
                            + " Количество персон " + amount);
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }
}
