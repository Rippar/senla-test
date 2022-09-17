package by.murzo.inetshop.senlatest.repository;

import by.murzo.inetshop.senlatest.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
