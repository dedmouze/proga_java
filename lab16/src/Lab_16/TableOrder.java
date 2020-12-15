package Lab_16;

import java.util.Arrays;
import java.util.Comparator;

public class TableOrder implements Order{

    private int size = 0;
    private MenuItem[] items;
    Customer customer;

    TableOrder(){
        items=new MenuItem[size];
    }

    private class CostComparator implements Comparator<MenuItem> {

        @Override
        public int compare(MenuItem o1, MenuItem o2) {
            return -(o1.getCost()-o2.getCost());
        }
    }

    @Override
    public boolean add(MenuItem item) {

        if (items.length<=size){
            items= Arrays.copyOf(items, size+1);
        }
        items[size]=item;
        size++;
        return true;
    }

    @Override
    public String[] itemsNames() {
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i]=items[i].getName();
        }
        return names;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName()==itemName){c++;}
        }
        return c;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        int c = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)){c++;}
        }
        return c;
    }

    @Override
    public MenuItem[] getItems() {
        return items;
    }

    private MenuItem remove(int index){
        MenuItem[] temp = new MenuItem[items.length-1];
        MenuItem e = items[index];
        int c=0;
        for (int i = 0; i < items.length-1; i++) {
            if (i!=index){
                temp[c]=items[i];
                c++;
            }
        }
        items=temp;
        size--;
        return e;
    }
    @Override
    public boolean remove(String itemName) {
        for (int i = 0; i <size ; i++) {
            if (items[i].getName()==itemName){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {
        for (int i = 0; i <size ; i++) {
            if (items[i]==item){
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int c= 0;
        while (remove(itemName)){
            c++;
        }
        return c;
    }

    @Override
    public int removeAll(MenuItem item) {
        int c= 0;
        while (remove(item)){
            c++;
        }
        return c;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        Arrays.sort(items, new CostComparator());
        return items;
    }

    @Override
    public int costTotal() {
        int cost = 0;
        for (int i = 0; i < size; i++) {
            cost+=items[i].getCost();
        }
        return cost;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer= customer;
    }
}
