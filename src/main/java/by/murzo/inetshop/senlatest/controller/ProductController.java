package by.murzo.inetshop.senlatest.controller;

import by.murzo.inetshop.senlatest.model.Product;
import by.murzo.inetshop.senlatest.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping(path = "/{productId}", consumes = "application/json")
    public Product patchProduct(@PathVariable("productId") Long productId,
                                @RequestBody Product patch) {
        Product product = repository.findById(productId).get();
        if (patch.getName() != null) {
            product.setName(patch.getName());
        }

        if (patch.getStatus() != null) {
            product.setStatus(patch.getStatus());
        }

        return repository.save(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) {
        try {
            Product product = repository.findById(productId).get();

            if (product.getStatus().equals(Product.productStatus.IN_STOCK) || product.getStatus().equals(Product.productStatus.RUNNING_LOW)) {
                log.info("Deleting is forbidden");
            } else {
                repository.deleteById(productId);
            }
        } catch (EmptyResultDataAccessException e) {
            log.info("Product not found");
        }
    }

    @GetMapping(params = "sorted")
    public Iterable<Product> sortedProducts() {
        //todo
        //PageRequest page = PageRequest.of(0,12,Sort.by("quantity").descending());
        //return repository.findAll(page).getContent();
        return repository.findAll();
    }
}
