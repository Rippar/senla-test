package by.murzo.inetshop.controller;

import by.murzo.inetshop.model.Order;
import by.murzo.inetshop.repository.OrderRepository;
import by.murzo.inetshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/orders", produces = "application/json")
public class OrderController {

    private final OrderService orderService;

    @PostMapping(consumes = "application/json")
    public Long postOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping(params = "sorted")
    public List<Order> sortedOrders() {
        return orderService.getOrdersSortedByUserAndCreatedAt();
    }
}
