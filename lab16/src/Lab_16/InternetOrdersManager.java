package Lab_16;

public class InternetOrdersManager implements OrdersManager {
    private QueueNode head = null;
    private QueueNode tail = null;
    private int size = 0;

    private static class QueueNode{
        Order item;
        InternetOrdersManager.QueueNode next;
        InternetOrdersManager.QueueNode prev;

        QueueNode(InternetOrdersManager.QueueNode prev, Order item, InternetOrdersManager.QueueNode next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public int itemsQuantity(String itemName) {
        int c = 0;
        for (QueueNode i = head; i!=null; i=i.next){
            c+=i.item.itemQuantity(itemName);
        }
        return c;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int c = 0;
        for (QueueNode i = head; i!=null; i=i.next){
            c+=i.item.itemQuantity(item);
        }
        return c;
    }

    @Override
    public Order[] getOrders() {
        Order[] orders = new Order[size];
        int p = 0;
        for (QueueNode i = head; i!=null; i=i.next){
            orders[p]=i.item;
            p++;
        }
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int c = 0;
        for (QueueNode i = head; i!=null; i=i.next){
            c+=i.item.costTotal();
        }
        return c;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }

    public boolean add(Order order){
        QueueNode first =head;
        QueueNode newNode = new QueueNode(null, order, first);
        head = newNode;
        if (first == null){
            tail = newNode;
        }
        else {
            first.prev=newNode;
        }
        size++;
        return true;
    }

    public Order remove(){
        QueueNode last = tail;
        QueueNode prev = last.prev;
        Order order = last.item;
        last.item = null;
        last.prev = null;
        tail=prev;
        if (prev==null){
            head=null;
        }
        else{
            prev.next=null;
        }
        size--;
        return order;
    }

    public Order order(){
        return tail.item;
    }

    public String[] getNames(){
        String[] names = new String[getOrders().length];
        int c = 0;
        for (QueueNode i = head; i !=null; i=i.next) {
            names[c]=i.item.getCustomer().getFirstName()+" "+i.item.getCustomer().getSecondName();
            c++;
        }
        return names;
    }

    public String to_String(int i_num){
        int c = 0;
        QueueNode i = head;
        String text;
        while(c<i_num && i!=null){
            i=i.next;
            c++;
        }
        String PI = String.format("First name: %s\nSecond name: %s\nAge: %s\n", i.item.getCustomer().getFirstName(), i.item.getCustomer().getSecondName(), i.item.getCustomer().getAge());
        Address cadr = i.item.getCustomer().getAddress();
        String Adr = String.format("%s, st.%s, b.%d, f.%d\n", cadr.getCityName(), cadr.getStreetName(), cadr.getBuildingNumber(), cadr.getApartmentNumber());
        String OrdersInfo = "Order:";
        MenuItem[] items = i.item.getItems();
        for (MenuItem k : items) {
            OrdersInfo+="\n"+k.getName()+"   "+k.getDescription()+"   "+k.getCost();
        }

        String allInfo = String.format("Orders: %d, Sum: %d\n", ordersQuantity(), ordersCostSummary());
        String orderResult = String.format("\n\nItems: %d \tSummary: %d", i.item.itemsQuantity(),  i.item.costTotal());
        return allInfo+PI+Adr+OrdersInfo+orderResult;
    }
}
