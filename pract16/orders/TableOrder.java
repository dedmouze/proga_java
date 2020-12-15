package pract15.orders;

import pract15.Customer;
import pract15.interfaces.Order;
import pract15.menu.MenuItem;
import pract15.utils.ItemsSorter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TableOrder implements Order {
    private final int DEFAULT_SIZE_OF_ARRAY = 10;
    private int size;
    private MenuItem[] items;

    public TableOrder() {
        this.items = new MenuItem[DEFAULT_SIZE_OF_ARRAY];
        this.size = 0;
    }

    public TableOrder(int arraySize)
    {
        this.items = new MenuItem[arraySize];
        this.size = 0;
    }

    public boolean add(MenuItem item) {
        if (size < items.length) {
            items[size] = item;
            size++;
            return true;
        }
        return false;
    }

    public String[] itemsNames() {
        if (size > 0)
        {
            String[] names = new String[size];
            int i = 0;
            while (i < size) {
                names[i] = this.items[i].getName();
                i++;
            }
            return names;
        }
        else
            return null;
    }

    public int itemsQuantity() {
        return this.size;
    }
    public int itemQuantity(String itemName) {
        int countItem = 0;
        int i = 0;

        while (i < size) {
            if (this.items[i].getName().equals(itemName))
                countItem++;
            i++;
        }
        return countItem;
    }
    public int itemQuantity(MenuItem item) {
        int countItem = 0;
        int i = 0;

        while (i < size)
        {
            if (this.items[i] == item)
                countItem++;
            i++;
        }
        return countItem;
    }

    public MenuItem[] getItems() { return this.items; }
    public boolean remove(String itemName) {
        MenuItem[] new_items = new MenuItem[this.items.length];
        int i = 0;
        int k = 0;
        boolean isDelete = false;

        if (itemQuantity(itemName) != 0)
        {
            while (k < size) {
                if (!this.items[k].getName().equals(itemName) || isDelete) {
                    new_items[i] = this.items[k];
                    i++;
                    k++;
                }
                else if (!isDelete)
                {
                    isDelete = true;
                    k++;
                }
            }
            this.items = new_items;
            this.size = i;
            return true;
        }
        else
            return false;
    }
    public boolean remove(MenuItem item) {
        MenuItem[] new_items = new MenuItem[this.items.length];
        int i = 0;
        int k = 0;
        boolean isDelete = false;

        if (itemQuantity(item) != 0)
        {
            while (k < size) {
                if (this.items[k] != item || isDelete) {
                    new_items[i] = this.items[k];
                    i++;
                    k++;
                }
                else if (!isDelete)
                {
                    isDelete = true;
                    k++;
                }
            }
            this.items = new_items;
            this.size = i;
            return true;
        }
        else
            return false;
    }

    public boolean removeAll(String itemName) {
        MenuItem[] new_items = new MenuItem[this.items.length];
        int i = 0;
        int k = 0;

        if (itemQuantity(itemName) != 0)
        {
            while (k < size) {
                if (!this.items[k].getName().equals(itemName)) {
                    new_items[i] = this.items[k];
                    i++;
                }
                k++;
            }
            this.items = new_items;
            this.size = i;
            return true;
        }
        else
            return false;
    }


    public boolean removeAll(MenuItem item) {
        MenuItem[] new_items = new MenuItem[this.items.length];
        int i = 0;
        int k = 0;

        if (itemQuantity(item) != 0)
        {
            while (k < size) {
                if (this.items[k] != item) {
                    new_items[i] = this.items[k];
                    i++;
                }
                k++;
            }
            this.items = new_items;
            this.size = i;
            return true;
        }
        else
            return false;
    }
    public MenuItem[] sortedItemsByCostDesc() {
        ItemsSorter.sort(this.items);
        return items;
    }
    public int costTotal() {
        int total = 0;
        int i = 0;

        while (i < size){
            if (items[i] != null)
                total += items[i].getCost();
            i++;
        }
        return total;
    }
    public Customer getCustomer() { return null; }
    public void setCustomer(Customer customer) { }
}
