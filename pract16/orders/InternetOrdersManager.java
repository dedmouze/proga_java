package pract15.orders;

import pract15.interfaces.Order;
import pract15.interfaces.OrdersManager;
import pract15.menu.MenuItem;

public class InternetOrdersManager implements OrdersManager {
    private QueueNode head;
    private QueueNode tail;
    private int size;


    public boolean add(Order order) {
        return false;
    }

    //public Order remove() { }
    //public Order order() { }

    public int itemsQuantity(String itemName) {
        return 0;
    }

    public int itemsQuantity(MenuItem item) {
        return 0;
    }

    public Order[] getOrders() {
        return new Order[0];
    }

    public int ordersCostSummary() {
        return 0;
    }

    public int ordersQuantity() {
        return 0;
    }
}
