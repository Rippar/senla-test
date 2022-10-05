package by.murzo.inetshop.service;

import by.murzo.inetshop.model.Order;
import by.murzo.inetshop.projection.OrderView;

import java.util.List;

public interface OrderService {

    Long saveOrder(Order order);

    List<OrderView> getOrdersSortedByUserAndCreatedAt();

}
