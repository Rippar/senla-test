package by.murzo.inetshop.repository;

import by.murzo.inetshop.model.OrderItemKey;
import by.murzo.inetshop.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemKey> {
}
