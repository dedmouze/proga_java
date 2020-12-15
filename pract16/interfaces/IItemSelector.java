package pract15.interfaces;


@FunctionalInterface
public interface IItemSelector<E> {
    boolean selectIt(E item);
}
