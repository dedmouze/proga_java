package Lab_16;


import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ListNode<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    private void linkFirst(E e) {
        Node<E> f = first;
        Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    private void linkLast(E e) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    private E unlinkFirst(Node<E> f) {
        E element = f.item;
        Node<E> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        E element = l.item;
        Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    public E removeFirst() {
        Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    public E removeLast() {
        Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }


    public void addLast(E item){
        linkLast(item);
    }

    public void addFirst(E item){
        linkFirst(item);
    }

    public E getFirst() {
        Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    public E getLast() {
        Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
