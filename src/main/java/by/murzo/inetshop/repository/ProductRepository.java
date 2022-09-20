package by.murzo.inetshop.repository;

import by.murzo.inetshop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
