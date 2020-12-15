package pract8;

public class BoundedWaitList<T> extends WaitList<T> {
    private int capacity;

    public BoundedWaitList(int capacity)
    {
        super();
        this.capacity = capacity;
    }
    public int getCapacity() {
        return capacity;
    }

    public void add(T element) {
        if (super.content.size() < capacity)
            super.add(element);
        else
            System.out.println("The list is full");
    }

    public String toString() {
        return "Your BoundedWaitList " +
                "capacity = " + capacity +
                "\ncontent = " + content;
    }
}
