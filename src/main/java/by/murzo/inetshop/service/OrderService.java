package by.murzo.inetshop.service;

import by.murzo.inetshop.model.Order;

import java.util.List;

public interface OrderService {

    Long saveOrder(Order order);

    List<Order> getOrdersSortedByUserAndCreatedAt();

}
