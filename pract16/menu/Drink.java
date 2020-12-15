package pract15.menu;

import pract15.interfaces.Alcoholable;

/**
 *
 *  Класс описывает сущность – напиток и характеризуется следующими свойствами - стоимостью, названием и описанием.
 *  Конструкторы:
 *  1. принимающий два параметра – название и описание. Стоимость при этом инициализируется значением 0;
 *  2. принимающий три параметра – стоимость, название и описание.
 *
 *  Методы:
 * − возвращающий стоимость.
 * − возвращающий название.
 * − возвращающий описание.
 * */

public final class Drink extends MenuItem implements Alcoholable {
    private final double alcoholVol;
    private final DrinkTypeEnum type;
    private static final int INIT_COST = 0;

    public Drink(double alcoholVol, DrinkTypeEnum type, String name, String description) throws IllegalArgumentException {
        if (name.equals("") || name.isEmpty() || description.equals("") || description.isEmpty())
            throw new IllegalArgumentException();
        this.type = type;
        this.alcoholVol = alcoholVol;
        this.cost = INIT_COST;
        this.name = name;
        this.description = description;
    }

    public Drink(double alcoholVol, DrinkTypeEnum type, int cost, String name, String description) {
        if (name.equals("") || name.isEmpty() || description.equals("") || description.isEmpty() || cost < 0)
            throw new IllegalArgumentException();
        this.type = type;
        this.alcoholVol = alcoholVol;
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return (this.alcoholVol > 0);
    }

    @Override
    public double getAlcoholVol() {
        return this.alcoholVol;
    }
}
