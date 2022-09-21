package by.murzo.inetshop.service;

import by.murzo.inetshop.exception.ForbiddanceOnDeletionException;
import by.murzo.inetshop.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    void deleteProduct(Long productId) throws ForbiddanceOnDeletionException;

    List<Product> getProductsSortedByOrders();
}
