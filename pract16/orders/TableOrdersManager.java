package pract15.orders;

import pract15.interfaces.Order;
import pract15.interfaces.OrdersManager;
import pract15.menu.MenuItem;

public class TableOrdersManager implements OrdersManager {

    private Order[] orders;
    public void add(Order order, int tableNumber) { }
    public void addItem(MenuItem item, int tableNumber) { }
    public int freeTableNumber() {
        return 0;
    }
    public int[] freeTableNumbers() {
        return new int[0];
    }
    public Order getOrder(int tableNumber) {
        return null;
    }
    public void remove(int tableNumber) { }
    public int remove(Order order) {
        return 0;
    }
    public int removeAll(Order order) {
        return 0;
    }
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
