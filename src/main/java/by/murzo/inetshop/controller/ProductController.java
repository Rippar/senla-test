package by.murzo.inetshop.controller;

import by.murzo.inetshop.projection.ProductView;
import by.murzo.inetshop.exception.ForbiddanceOnDeletionException;
import by.murzo.inetshop.model.Product;
import by.murzo.inetshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/products", produces = "application/json")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(consumes = "application/json")
    public Product postProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping(path = "/{productId}", consumes = "application/json")
    public Product putProduct(@PathVariable("productId") Long productId,
                              @RequestBody Product product) {
        product.setId(productId);
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") Long productId) throws ForbiddanceOnDeletionException {
        productService.deleteProduct(productId);
    }

    @GetMapping(params = "sortedByOrders")
    public List<ProductView> sortedProducts() {
        return productService.getProductsSortedByOrders();
    }
}
