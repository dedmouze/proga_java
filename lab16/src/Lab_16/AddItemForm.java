package Lab_16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddItemForm extends JFrame {

    public void add_drink(Drink drink){
        Customer customer = tableOrder.getCustomer();
        if ((customer==null || customer.getAge()<18) && drink.isAlcoholicDrink()){
            JOptionPane.showMessageDialog(null, "You mustn't sell alchohol to men under 18!");
        }
        else{
            tableOrder.add(drink);
            mFrame.update(t_num, i_num);
        }
    }
    Order tableOrder;
    int t_num;
    int i_num;
    MFrame mFrame;
    AddItemForm(Order tableOrder, int t_num, int i_num, MFrame mFrame){
        super("Add item form");
        this.tableOrder = tableOrder;
        this.t_num=t_num;
        this.i_num=i_num;
        this.mFrame=mFrame;
        setSize(400,  500);
        setResizable(false);
        setLayout(new GridLayout(0, 2));
        JLabel l_drinks = new JLabel("Drinks");
        l_drinks.setHorizontalAlignment(JLabel.CENTER);
        JLabel l_dishes = new JLabel("Dish set");
        l_dishes.setHorizontalAlignment(JLabel.CENTER);

        JPanel drinks = new JPanel(new GridLayout(19, 0));
        drinks.setBackground(new Color(255, 235, 209));
        JPanel dishes = new JPanel();
        dishes.setBackground(new Color(250, 236, 206));

        JPanel dishes_menu = new JPanel(new GridLayout(8, 0));
        dishes_menu.setBackground(new Color(250, 236, 206));
        JLabel l_dish_name = new JLabel("Enter dish name: ");
        JTextField t_dish_name = new JTextField();
        t_dish_name.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        JLabel l_dish_desc = new JLabel("Enter dish description: ");
        JTextField t_dish_desc = new JTextField();
        t_dish_desc.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        JLabel l_dish_cost = new JLabel("Enter dish cost: ");
        JTextField t_dish_cost = new JTextField();
        t_dish_cost.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        JButton add_dish = new JButton("Add Dish");
        add_dish.setMargin(new Insets(5, 62, 5, 62));
        add_dish.setBackground(new Color(255, 244, 222));
        add_dish.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
        JButton close = new JButton("Finish");
        close.setMargin(new Insets(5, 70, 5, 70));
        close.setBackground(new Color(255, 244, 222));
        close.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));


        JButton beer = new JButton("Beer");
        beer.setBackground(new Color(255, 234, 184));
        beer.setBorder(BorderFactory.createEmptyBorder());
        beer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.BEER, "Light", 120));
            }
        });

        JButton wine = new JButton("Wine");
        wine.setBackground(new Color(248, 228, 179));
        wine.setBorder(BorderFactory.createEmptyBorder());
        wine.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.WINE, "Red", 325));
            }
        });

        JButton vodka = new JButton("Vodka");
        vodka.setBackground(new Color(241, 222, 178));
        vodka.setBorder(BorderFactory.createEmptyBorder());
        vodka.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.VODKA, "Russian", 100));
            }
        });

        JButton brandy = new JButton("Brendi");
        brandy.setBackground(new Color(232, 216, 172));
        brandy.setBorder(BorderFactory.createEmptyBorder());
        brandy.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.BRANDY, "Hot Rat", 130));
            }
        });

        JButton champagne = new JButton("Champagne");
        champagne.setBackground(new Color(219, 204, 163));
        champagne.setBorder(BorderFactory.createEmptyBorder());
        champagne.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.CHAMPAGNE, "from the Paris", 610));
            }
        });

        JButton whiskey = new JButton("Whiskey");
        whiskey.setBackground(new Color(212, 197, 158));
        whiskey.setBorder(BorderFactory.createEmptyBorder());
        whiskey.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.WHISKEY, "Red Label", 250));
            }
        });

        JButton tequila = new JButton("Tequila");
        tequila.setBackground(new Color(205, 190, 154));
        tequila.setBorder(BorderFactory.createEmptyBorder());
        tequila.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.TEQUILA, "with Guava juice", 324));
            }
        });

        JButton rum = new JButton("Rum");
        rum.setBackground(new Color(198, 182, 146));
        rum.setBorder(BorderFactory.createEmptyBorder());
        rum.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.RUM, "for real pirates", 144));
            }
        });

        JButton vermouth = new JButton("Vermouth");
        vermouth.setBackground(new Color(203, 187, 150));
        vermouth.setBorder(BorderFactory.createEmptyBorder());
        vermouth.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.VERMOUTH, "Special with herbs", 437));
            }
        });

        JButton liquor = new JButton("Liquor");
        liquor.setBackground(new Color(208, 192, 155));
        liquor.setBorder(BorderFactory.createEmptyBorder());
        liquor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.LIQUOR, "veryyy sweeeet", 223));
            }
        });

        JButton jagermeister = new JButton("Jagermeister");
        jagermeister.setBackground(new Color(205, 188, 152));
        jagermeister.setBorder(BorderFactory.createEmptyBorder());
        jagermeister.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.JAGERMEISTER, "for real deer hunters", 506));
            }
        });

        JButton juice = new JButton("Juice");
        juice.setBackground(new Color(217, 199, 160));
        juice.setBorder(BorderFactory.createEmptyBorder());
        juice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.JUICE, "Apple juice", 130));
            }
        });

        JButton coffee = new JButton("Coffee");
        coffee.setBackground(new Color(226, 207, 166));
        coffee.setBorder(BorderFactory.createEmptyBorder());
        coffee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.COFFEE, "Latte", 90));
            }
        });

        JButton g_tea = new JButton("Green tea");
        g_tea.setBackground(new Color(238, 218, 174));
        g_tea.setBorder(BorderFactory.createEmptyBorder());
        g_tea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.GREEN_TEA, "from China with love", 50));
            }
        });

        JButton b_tea = new JButton("Black tea");
        b_tea.setBackground(new Color(239, 220, 175));
        b_tea.setBorder(BorderFactory.createEmptyBorder());
        b_tea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.BLACK_TEA, "from India with love", 50));
            }
        });

        JButton milk = new JButton("Milk");
        milk.setBackground(new Color(245, 225, 180));
        milk.setBorder(BorderFactory.createEmptyBorder());
        milk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.MILK, "Ultrawhite", 20));
            }
        });

        JButton water = new JButton("Water");
        water.setBackground(new Color(253, 231, 186));
        water.setBorder(BorderFactory.createEmptyBorder());
        water.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.WATER, "Cheap water", 1));
            }
        });

        JButton soda = new JButton("Soda");
        soda.setBackground(new Color(253, 234, 192));
        soda.setBorder(BorderFactory.createEmptyBorder());
        soda.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                add_drink(new Drink(DrinkTypeEnum.SODA, "Not cheap water", 10));
            }
        });

        add_dish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String name = t_dish_name.getText();
                String desc = t_dish_desc.getText();
                int cost = 10;
                try{
                    cost = Integer.parseInt(t_dish_cost.getText());
                } catch (Exception t){
                    System.out.println(t.getMessage());
                }
                Dish dish = new Dish(name, desc, cost);
                tableOrder.add(dish);
                t_dish_name.setText("");
                t_dish_desc.setText("");
                t_dish_cost.setText("");
                mFrame.update(t_num, i_num);
            }
        });

        close.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
            }
        });


        add(drinks);
        add(dishes);
        drinks.add(l_drinks);
        drinks.add(beer);
        drinks.add(wine);
        drinks.add(vodka);
        drinks.add(brandy);
        drinks.add(champagne);
        drinks.add(whiskey);
        drinks.add(tequila);
        drinks.add(rum);
        drinks.add(vermouth);
        drinks.add(liquor);
        drinks.add(jagermeister);
        drinks.add(juice);
        drinks.add(coffee);
        drinks.add(b_tea);
        drinks.add(g_tea);
        drinks.add(milk);
        drinks.add(water);
        drinks.add(soda);
        dishes.add(dishes_menu);
        dishes_menu.add(l_dishes);
        dishes_menu.add(l_dish_name);
        dishes_menu.add(t_dish_name);
        dishes_menu.add(l_dish_desc);
        dishes_menu.add(t_dish_desc);
        dishes_menu.add(l_dish_cost);
        dishes_menu.add(t_dish_cost);
        dishes.add(add_dish);
        dishes.add(close);


        setVisible(true);
    }
}
