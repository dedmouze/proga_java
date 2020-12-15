package pract15.menu;

/**
 *
 *  Класс описывает сущность – блюдо и характеризуется следующими свойствами - стоимостью, названием и описанием.
 *  Конструкторы:
 *  1. принимающий два параметра – название и описание. Стоимость при этом инициализируется значением 0;
 *  2. принимающий три параметра – стоимость, название и описание.
 *
 *  Методы:
 * − возвращающий стоимость.
 * − возвращающий название.
 * − возвращающий описание.
 * */

public final class Dish extends MenuItem {
    private static final int INIT_COST = 0;

    public Dish(String name, String description) throws IllegalArgumentException {
        if (name.equals("") || name.isEmpty() || description.equals("") || description.isEmpty())
            throw new IllegalArgumentException();

        this.cost = INIT_COST;
        this.name = name;
        this.description = description;
    }

    public Dish(int cost, String name, String description) throws IllegalArgumentException {
        if (name.equals("") || name.isEmpty() || description.equals("") || description.isEmpty() || cost < 0)
            throw new IllegalArgumentException();
        this.cost = cost;
        this.name = name;
        this.description = description;
    }
}
