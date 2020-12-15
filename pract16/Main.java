package pract15;

import pract15.menu.Dish;
import pract15.menu.Drink;
import pract15.menu.DrinkTypeEnum;
import pract15.menu.MenuItem;
import pract15.orders.TableOrder;

public class Main {

    public static void main(String[] args) {
        TableOrder tableOrder = new TableOrder(20);

        MenuItem someDrink = new Drink(40, DrinkTypeEnum.valueOf("VODKA"),
                300, "Столичная водка", "RUSSIAN VODKA");
        MenuItem someDish = new Dish(50000, "Фритатта", "Фритатта с лобстером и икрой");
        MenuItem yetAnotherDrink = new Drink(0, DrinkTypeEnum.valueOf("JUICE"),
                150, "Сок", "Сок апельсиновый 200мл.");
        MenuItem yetAnotherDish = new Dish(30, "Доширак", "Лапша быстрого приготовления");



        tableOrder.add(someDrink);
        tableOrder.add(someDish);
        tableOrder.add(yetAnotherDrink);
        tableOrder.add(yetAnotherDish);
        tableOrder.add(yetAnotherDish);

        tableOrder.remove(yetAnotherDish);
        //tableOrder.removeAll("Доширак");
        //tableOrder.removeAll(yetAnotherDish);
        tableOrder.sortedItemsByCostDesc();


        System.out.println("Цена всех блюд и напитков: " + tableOrder.costTotal());

        String[] itemsNames = tableOrder.itemsNames();
        for (String name : itemsNames)
            System.out.println(name);


    }
}
