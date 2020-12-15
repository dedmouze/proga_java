package Lab_16;

import java.awt.*;

public class TableOrdersManager implements OrdersManager {

    class OrderAlreadyAddedException extends Exception{
        OrderAlreadyAddedException(int t_num){
            super(String.format("Table with number %d table is unavailable",t_num ));
        }
    }

    class IllegalTableNumber extends RuntimeException{
        IllegalTableNumber(int t_num, int size){
            super(String.format("Table with number %d table is not exists\nTry numbers until %d",t_num, size ));
        }
    }

    private Order[] orders = new Order[8];
    @Override
    public int itemsQuantity(String itemName) {
        int c = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i]!=null){
                c+=orders[i].itemQuantity(itemName);
            }
        }
        return c;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int c = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i]!=null){
                c+=orders[i].itemQuantity(item);
            }
        }
        return c;
    }

    @Override
    public Order[] getOrders() {
        Order[] r_orders = new Order[ordersQuantity()];
        int p = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i]!=null){
                r_orders[p] = orders[i];
                p++;
            }
        }
        return r_orders;
    }

    @Override
    public int ordersCostSummary() {
        Order[] r_orders = getOrders();
        int c = 0;
        for (Order i: r_orders) {
            c+=i.costTotal();
        }
        return c;
    }

    @Override
    public int ordersQuantity() {
        return orders.length - freeTableNumber();

    }

    public void add(Order order, int tableNumber) throws OrderAlreadyAddedException {
        if(tableNumber < orders.length && orders[tableNumber]==null){
            orders[tableNumber]=order;
        }
        else if(tableNumber >= orders.length){
            throw new IllegalTableNumber(tableNumber, orders.length);
        }
        else{
            throw new OrderAlreadyAddedException(tableNumber);
        }

    }

    public void addItem(MenuItem item, int tableNumber){
        if (tableNumber < orders.length && orders[tableNumber]!=null){
            orders[tableNumber].add(item);
        }
    }

    public int freeTableNumber(){
        int c= 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i]==null){
                c++;
            }
        }
        return c;
    }

    public int[] freeTableNumbers(){
        int[] t_nums = new int[freeTableNumber()];
        int p = 0;
        for (int i = 0; i < orders.length; i++) {
            if(orders[i]==null){
                t_nums[p]=i;
                p++;
            }
        }
        return t_nums;
    }

    public Order getOrder (int tableNumber){
        return orders[tableNumber];
    }

    public void remove(int tableNumber){
        orders[tableNumber]=null;
    }

    public int remove(Order order){
        for (int i = 0; i<orders.length; i++) {
            if(orders[i]==order){
                orders[i]=null;
                return i;
            }

        }
        return 0;
    }

    public int removeAll(Order order){
        int c = 0;
        for (Order i:orders) {
            if(i==order){
                i=null;
                c++;
            }
        }
        return c;
    }

    public String to_String(int t_num){
        if (orders[t_num]==null){
            return "This table is empty";
        }
        String customer="Customer: Not stated";
        if (getOrder(t_num).getCustomer()!=null){
            customer=String.format("Customer:\nFirst name: %s,\nSecond name: %s,\nAge: %d", getOrder(t_num).getCustomer().getFirstName(),
                    getOrder(t_num).getCustomer().getSecondName(), getOrder(t_num).getCustomer().getAge());
        }
        String orderItems = "\nOrder items: ";
        for (MenuItem i: getOrder(t_num).getItems()) {
            orderItems+="\n"+i.getName()+"   "+i.getDescription()+"   "+i.getCost();
        }

        String allInfo = String.format("Orders: %d, Sum: %d\n", ordersQuantity(), ordersCostSummary());

        String orderResult = String.format("\n\nItems: %d \tSummary: %d", getOrder(t_num).itemsQuantity(), getOrder(t_num).costTotal());
        return allInfo+customer+orderItems+orderResult;
    }
}
