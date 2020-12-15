package pract15.exceptions;

import pract15.interfaces.Order;

public class OrderAlreadyAddedException extends Exception {
    private final Order addedOrder;
    public Order getAddedOrder() {
        return addedOrder;
    }

    public OrderAlreadyAddedException(String message) {
        super(message);
        addedOrder = null;
    }

    public OrderAlreadyAddedException(Order addedOrder) {
        super("Order already added.");
        this.addedOrder = addedOrder;
    }

    public OrderAlreadyAddedException(String message, Order addedOrder) {
        super(message);
        this.addedOrder = addedOrder;
    }
}
