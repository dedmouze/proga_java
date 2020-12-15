package Lab_16;


import java.util.*;

public class InternetOrder implements Order {
    Customer customer;
    private int size = 0;
    private ListNode head = null;
    private ListNode tail = null;

    private class CostComparator implements Comparator<MenuItem>{

        @Override
        public int compare(MenuItem o1, MenuItem o2) {
            return -(o1.getCost()-o2.getCost());
        }
    }

    private static class ListNode{
        MenuItem item;
        ListNode next;
        ListNode prev;

        ListNode(ListNode prev, MenuItem element, ListNode next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    InternetOrder(){ }
    InternetOrder(MenuItem[] menuItems){

    }

    private void linkFirst(MenuItem e) {
        ListNode f = head;
        ListNode newNode = new ListNode(null, e, f);
        head = newNode;
        if (f == null)
            tail = newNode;
        else
            f.prev = newNode;
        size++;
    }

    private void linkLast(MenuItem e) {
        ListNode l = tail;
        ListNode newNode = new ListNode(l, e, null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }

    private MenuItem unlinkFirst(ListNode f) {
        MenuItem element = f.item;
        ListNode next = f.next;
        f.item = null;
        f.next = null;
        head = next;
        if (next == null)
            tail = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private MenuItem unlinkLast(ListNode l) {
        MenuItem element = l.item;
        ListNode prev = l.prev;
        l.item = null;
        l.prev = null;
        tail = prev;
        if (prev == null)
            head = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    MenuItem unlink(ListNode x) {
        MenuItem element = x.item;
        ListNode next = x.next;
        ListNode prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }




    @Override
    public boolean add(MenuItem item) {
        linkFirst(item);
        return true;
    }

    @Override
    public String[] itemsNames() {

        String[] items = new String[]{""};
        for (ListNode x = tail; x!=null ; x=x.prev) {
            items[items.length-1]=x.item.getName();
            items= Arrays.copyOf(items, items.length+1);
        }
        items= Arrays.copyOf(items, items.length-1);
        return items;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemQuantity(String itemName) {
        int c = 0;
        for (ListNode x = tail; x!=null ; x=x.prev) {
            if(x.item.getName()==itemName){
                c++;
            }
        }
        return c;
    }

    @Override
    public int itemQuantity(MenuItem item) {
        int c = 0;
        for (ListNode x = tail; x!=null ; x=x.prev) {
            if(x.item.equals(item)){
                c++;
            }
        }
        return c;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] items = new MenuItem[1];
        for (ListNode x = tail; x!=null ; x=x.prev) {
            items[items.length-1]=x.item;
            items= Arrays.copyOf(items, items.length+1);

        }
        items= Arrays.copyOf(items, items.length-1);
        return items;
    }

    @Override
    public boolean remove(String itemName) {

        for (ListNode x = tail; x!=null ; x=x.prev) {
            if(x.item.getName()==itemName){
                unlink(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(MenuItem item) {

        for (ListNode x = tail; x!=null ; x=x.prev) {
            if(x.item.equals(item)){
                unlink(x);
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        int c = 0;
        while(remove(itemName)){ c++;}
        return c;
    }

    @Override
    public int removeAll(MenuItem item) {
        int c = 0;
        while(remove(item)){ c++;}
        return c;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] items = getItems();
        Arrays.sort(items, new CostComparator());
        return items;
    }

    @Override
    public int costTotal() {
        int c = 0;
        for (ListNode x = tail; x!=null ; x=x.prev) {
            c+=x.item.getCost();
        }
        return c;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
