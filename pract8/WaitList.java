package pract8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList<T> implements IWaitList<T> {
    protected ConcurrentLinkedQueue<T> content;

    public WaitList(){
        content = new ConcurrentLinkedQueue<>();
    }
    public WaitList(Collection<T> c){ this.content = (ConcurrentLinkedQueue<T>) c; }

    public String toString() { return "WaitList content = " + content; }
    public void add(T element) { content.add(element); }
    public T remove() { return content.remove(); }
    public boolean contains(T element) {
        return content.contains(element);
    }
    public boolean containsAll(Collection<T> c) { return content.containsAll(c); }
    public boolean isEmpty() { return content.isEmpty(); }
}
