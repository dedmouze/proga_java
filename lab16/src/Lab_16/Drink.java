package Lab_16;

public final class Drink extends MenuItem implements Alcoholable{

    private DrinkTypeEnum type;
    private double AlcoholVol;

    Drink(DrinkTypeEnum type, String description){
        super(type.getName(), description, 0);
        this.type=type;
        this.AlcoholVol=type.getAlcoholVol();
    }

    Drink(DrinkTypeEnum type,  String description, int cost){
        super(type.getName(), description, cost);
        this.type=type;
        this.AlcoholVol=type.getAlcoholVol();
    }



    @Override
    public boolean isAlcoholicDrink() {
        return AlcoholVol>0.5 ? true : false;
    }

    @Override
    public double getAlcoholVol() {
        return AlcoholVol;
    }
}
