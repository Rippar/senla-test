package by.murzo.inetshop.repository;

import by.murzo.inetshop.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
