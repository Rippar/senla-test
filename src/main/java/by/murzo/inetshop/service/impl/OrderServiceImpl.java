package by.murzo.inetshop.service.impl;

import by.murzo.inetshop.model.Order;
import by.murzo.inetshop.projection.OrderView;
import by.murzo.inetshop.repository.OrderRepository;
import by.murzo.inetshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long saveOrder(Order order) {
        //todo the ProductStatus and userId check
        repository.save(order);
        return order.getId();
    }

    @Override
    public List<OrderView> getOrdersSortedByUserAndCreatedAt() {
        return repository.getOrdersSortedByUserAndCreatedAt();
    }
}
