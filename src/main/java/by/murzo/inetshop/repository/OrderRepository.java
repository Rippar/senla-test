package by.murzo.inetshop.repository;

import by.murzo.inetshop.model.Order;
import by.murzo.inetshop.projection.OrderView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


    @Query(value = "SELECT orders.id AS id, orders.users_id as userId, orders.status, orders.created_at as createdAt," +
            " GROUP_CONCAT(order_items.products_id) AS productsId  FROM orders RIGHT JOIN order_items ON orders.id = " +
            "order_items.orders_id GROUP BY id ORDER BY orders.users_id", nativeQuery = true)
    List<OrderView> getOrdersSortedByUserAndCreatedAt();
}
