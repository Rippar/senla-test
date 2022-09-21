package by.murzo.inetshop.service.impl;

import by.murzo.inetshop.exception.ForbiddanceOnDeletionException;
import by.murzo.inetshop.exception.ProductNotFoundException;
import by.murzo.inetshop.model.Product;
import by.murzo.inetshop.repository.ProductRepository;
import by.murzo.inetshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public Product saveProduct(Product product) {
        return repository.save(product);
    }


    @Override
    public void deleteProduct(Long productId) throws ForbiddanceOnDeletionException {
        Product product = repository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        if (product.getStatus().equals(Product.productStatus.IN_STOCK) || product.getStatus().equals(Product.productStatus.RUNNING_LOW)) {
            throw new ForbiddanceOnDeletionException("Deleting the product with status " + product.getStatus().name() + " is forbidden");
        } else {
            repository.deleteById(productId);
        }

    }

    @Override
    public List<Product> getProductsSortedByOrders() {
        //todo
//        PageRequest page = PageRequest.of(0,12,Sort.by("quantity").descending());
//        return repository.findAll(page).getContent();
        Iterable<Product> products = repository.findAll();
        return StreamSupport.stream(products.spliterator(), false).collect(Collectors.toList());
    }
}
