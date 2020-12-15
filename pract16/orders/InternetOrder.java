package pract15.orders;


import pract15.Customer;
import pract15.interfaces.IItemSelector;
import pract15.interfaces.Item;
import pract15.interfaces.Order;
import pract15.menu.MenuItem;
import pract15.utils.ItemsSorter;
import pract15.utils.MyArrayList;
import pract15.utils.CycledLinkedList;


public class InternetOrder extends CycledLinkedList<Item> implements Order {

    private IItemSelector<Item> getSelectorByName(String name) {
        return (item) -> item.getName().equals(name);
    }

    public Item[] select(IItemSelector<Item> selector) {
        var result = new MyArrayList<Item>();

        for (int i = 0; i < size; ++i) {
            if (selector.selectIt(next()))
                result.add(current.getData());
        }
        return (Item[])result.toArray();
    }

    public int countOf(IItemSelector<Item> selector) {
        int count = 0;

        for (int i = 0; i < size; ++i)
            if (selector.selectIt(next()))
                ++count;
        return count;
    }

    public int getOrderPrice() {
        int result = 0;

        prev();
        for (int i = 0; i < size; ++i)
            result += next().getCost();
        return result;
    }

    public String[] allNames() {
        Item[] items = toArray();
        MyArrayList<String> result = new MyArrayList<>(items.length);

        for (Item item : items)
            if (!result.contains(item.getName()))
                result.add(item.getName());
        return (String[])result.toArray();
    }

    public Item[] toSortedArray() {
        Item[] items = toArray();
        ItemsSorter.sort(items);
        return items;
    }

    public boolean removeByName(String name) {
        return remove(getSelectorByName(name));
    }
    public int removeAllByName(String name) {
        return removeAll(getSelectorByName(name));
    }
    public int getCount() {
        return size;
    }
    public int countOf(String name) {
        return countOf(getSelectorByName(name));
    }

    public boolean add(MenuItem item) {
        return false;
    }

    public String[] itemsNames() {
        return new String[0];
    }

    public int itemsQuantity() {
        return 0;
    }

    public int itemQuantity(String itemName) {
        return 0;
    }

    public int itemQuantity(MenuItem item) {
        return 0;
    }

    public MenuItem[] getItems() {
        return new MenuItem[0];
    }

    public boolean remove(String itemName) {
        return false;
    }

    public boolean remove(MenuItem item) {
        return false;
    }

    public boolean removeAll(String itemName) {
        return false;
    }

    public boolean removeAll(MenuItem item) {
        return false;
    }

    public MenuItem[] sortedItemsByCostDesc() {
        return new MenuItem[0];
    }

    public int costTotal() {
        return 0;
    }

    public Customer getCustomer() {
        return null;
    }

    public void setCustomer(Customer customer) {

    }
}
