package by.murzo.inetshop.senlatest.controller;

import by.murzo.inetshop.senlatest.model.Order;
import by.murzo.inetshop.senlatest.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/orders", produces = "application/json")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @PostMapping(consumes = "application/json")
    public Long postOrder(@RequestBody Order order) {
        //todo the ProductStatus and userId check
        repository.save(order);
        return order.getId();
    }

    @GetMapping(params = "sorted")
    public Iterable<Order> sortedOrders() {
        //todo the sorting by userId and createdAt
        return repository.findAll();
    }
}
