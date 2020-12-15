package pract7;


import java.util.ArrayList;

public class SimpleQueue<T> implements Queue<T> {

    private ArrayList<T> arrayList = new ArrayList<>();

    public void add(T item) {
        arrayList.add(item);
    }

    public T remove() {
        return arrayList.remove(0);
    }

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
}
