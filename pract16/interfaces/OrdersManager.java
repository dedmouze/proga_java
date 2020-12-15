package pract15.interfaces;

import pract15.menu.MenuItem;

public interface OrdersManager {

    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem item);
    Order[] getOrders();
    int ordersCostSummary();
    int ordersQuantity();
}
