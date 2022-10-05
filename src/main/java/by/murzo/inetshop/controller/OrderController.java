package by.murzo.inetshop.controller;

import by.murzo.inetshop.model.Order;
import by.murzo.inetshop.projection.OrderView;
import by.murzo.inetshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orders", produces = "application/json")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = "application/json")
    public Long postOrder(@RequestBody Order order) {

        return orderService.saveOrder(order);
    }

    @GetMapping(params = "sorted")
    public List<OrderView> sortedOrders() {
        return orderService.getOrdersSortedByUserAndCreatedAt();
    }
}
