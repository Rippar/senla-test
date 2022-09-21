package by.murzo.inetshop.service.impl;

import by.murzo.inetshop.model.Order;
import by.murzo.inetshop.repository.OrderRepository;
import by.murzo.inetshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    @Override
    public Long saveOrder(Order order) {
        //todo the ProductStatus and userId check
        repository.save(order);
        return order.getId();
    }

    @Override
    public List<Order> getOrdersSortedByUserAndCreatedAt() {
        //todo the sorting by userId and createdAt
        Iterable<Order> orders = repository.findAll();
        return StreamSupport.stream(orders.spliterator(), false).collect(Collectors.toList());
    }
}
