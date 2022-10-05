package by.murzo.inetshop.repository;

import by.murzo.inetshop.projection.ProductView;
import by.murzo.inetshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT name, price, SUM(quantity) AS orderedQuantity FROM inetshop.order_items RIGHT JOIN " +
            "inetshop" +
            ".products ON inetshop.order_items.products_id = inetshop.products.id GROUP BY products_id ORDER BY " +
            "orderedQuantity DESC", nativeQuery = true)
    List<ProductView> getSortedProducts();
}
