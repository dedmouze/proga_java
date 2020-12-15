package pract15.utils;

import pract15.menu.Dish;
import pract15.interfaces.IItemSelector;

public class CycledLinkedList<E> {
    protected LinkedListNode<E> current;
    protected int size;

    public static final int INIT_SIZE = 0;

    public static void main(String[] args) {
        var test = new CycledLinkedList<Dish>();
        var first = new Dish(1, "first", "123");
        test.add(first);
        test.add(new Dish(2, "second", "123"));
        test.add(new Dish(3, "third", "123"));
        test.add(new Dish(4, "second", "321"));

        for (int i = 0; i < test.size; ++i)
            System.out.println(test.prev());

        test.next();
        test.remove((item) -> item.getName().equals("second"));
        test.remove((item) -> item.getName().equals("first"));
        System.out.println("###");

        for (int i = 0; i < test.size; ++i)
            System.out.println(test.next());
    }

    public CycledLinkedList() {
        this.current = null;
        this.size = INIT_SIZE;
    }

    public CycledLinkedList(E[] items) {
        this.current = null;
        this.size = INIT_SIZE;

        if (items.length == 0)
            return;
        for (E item : items)
            add(item);
    }

    public boolean add(E item) {
        LinkedListNode<E> newNode = new LinkedListNode<>(item);

        if (current == null) {
            current = newNode;
            current.setPrev(current);
            current.setNext(current);
        }
        else {
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            current.getNext().setPrev(newNode);
            current.setNext(newNode);
            current = newNode;
        }

        ++size;
        return true;
    }


    public boolean remove(IItemSelector<E> selector) {
        for (int i = 0; i < size; ++i)
            if (selector.selectIt(prev())) {
                LinkedListNode<E> newCurrent = current.getNext();
                current.getPrev().setNext(newCurrent);
                newCurrent.setPrev(current.getPrev());
                --size;
                current = newCurrent;

                return true;
            }

        return false;
    }


    public int removeAll(IItemSelector<E> selector) {
        int count = 0;

        for (int i = 0; i < size; ++i) {
            if (selector.selectIt(next())) {
                LinkedListNode<E> newCurrent = current.getNext();
                current.getPrev().setNext(newCurrent);
                newCurrent.setPrev(current.getPrev());
                --size;
                current = newCurrent;

                ++count;
            }
        }

        return count;
    }


    public E next() {
        E result = null;

        if (current != null) {
            result = current.getNext().getData();
            current = current.getNext();
        }
        return result;
    }


    public E prev() {
        E result = null;

        if (current != null) {
            result = current.getPrev().getData();
            current = current.getPrev();
        }
        return result;
    }


    public E[] toArray() {
        var result = new Object[size];

        prev();
        for (int i = 0; i < size; ++i)
            result[i] = next();
        return (E[])result;
    }

    public int getSize() {
        return size;
    }
}
