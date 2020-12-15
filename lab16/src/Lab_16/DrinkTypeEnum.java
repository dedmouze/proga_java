package Lab_16;

public enum DrinkTypeEnum {
    BEER("Beer", 7.0),
    WINE("Wine", 9.0),
    VODKA("Vodka", 50.5),
    BRANDY("Brendi", 39.3),
    CHAMPAGNE("Champagne", 9.8),
    WHISKEY("Whiskey", 46.5),
    TEQUILA("Tequila", 50.0),
    RUM("Rom", 37.4),
    VERMOUTH("Vermouth", 18),
    LIQUOR("Liquor", 35.3),
    JAGERMEISTER("Jagermeister", 40.1),
    JUICE("Juice", 0.0),
    COFFEE("Coffee", 0.0),
    GREEN_TEA("Green tea", 0.0),
    BLACK_TEA("Black tea", 0.0),
    MILK("Milk", 0.0),
    WATER("Water", 0.0),
    SODA("Soda", 0.0);

    public String getName() {
        return name;
    }

    public double getAlcoholVol() {
        return AlcoholVol;
    }



    private String name;
    private double AlcoholVol;
    private DrinkTypeEnum(String name, double AlcoholVol){
        this.name = name;
        this.AlcoholVol=AlcoholVol;
    }
}
