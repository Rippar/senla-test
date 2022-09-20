package by.murzo.inetshop.controller;

import by.murzo.inetshop.exception.ForbiddanceOnDeletionException;
import by.murzo.inetshop.exception.ProductNotFoundException;
import by.murzo.inetshop.model.Product;
import by.murzo.inetshop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping(value = "/api/products", produces = "application/json")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @PostMapping(consumes = "application/json")
    public Product postProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping(path = "/{productId}", consumes = "application/json")
    public Product putProduct(@PathVariable("productId") Long productId,
                              @RequestBody Product product) {
        product.setId(productId);
        return repository.save(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) throws ForbiddanceOnDeletionException {
        Product product = repository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not " +
                "found"));

        if (product.getStatus().equals(Product.productStatus.IN_STOCK) || product.getStatus().equals(Product.productStatus.RUNNING_LOW)) {
            throw new ForbiddanceOnDeletionException("Deleting the product with status " + product.getStatus().name() + " is forbidden");
        } else {
            repository.deleteById(productId);
        }

        log.info("Product not found");

    }

    @GetMapping(params = "sorted")
    public Iterable<Product> sortedProducts() {
        //todo
        //PageRequest page = PageRequest.of(0,12,Sort.by("quantity").descending());
        //return repository.findAll(page).getContent();
        return repository.findAll();
    }
}
