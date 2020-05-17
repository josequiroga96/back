package com.ecommerce.back.controllers;

import com.ecommerce.back.exceptions.ResourceNotFoundException;
import com.ecommerce.back.models.Product;
import com.ecommerce.back.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public List<Product> getAllProducts(@RequestParam Map<String,String> allRequestParams) {
        List<Product> products = productRepository.findAll();
        List<Product> result = products;

        String category = allRequestParams.get("category");
        String searchKeyword = allRequestParams.get("searchKeyword");
        String sortOrder = allRequestParams.get("sortOrder");

        if (category != null) {
            result = new ArrayList<>();
            for (Product product: products) if (product.getCategory().equals(category)) result.add(product);
        }
        if (searchKeyword != null) {
            List<Product> aux = new ArrayList<>();
            for (Product product: result) if (product.getName().contains(searchKeyword)) aux.add(product);
            result = aux;
        }

        if (sortOrder != null) {
            if (sortOrder.equals("lowest")) {
                result.sort((p1, p2) -> Float.compare(p1.getPrice(), p2.getPrice()));
            } else {
                result.sort((p1, p2) -> Float.compare(p2.getPrice(), p1.getPrice()));
            }
        }

        return result;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
                                                 @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        product.setName(productDetails.getName());
        product.setImage(productDetails.getImage());
        product.setBrand(productDetails.getBrand());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        product.setStock(productDetails.getStock());
        product.setDescription(productDetails.getDescription());
        product.setRating(productDetails.getRating());
        product.setReviews(productDetails.getReviews());

        final Product updatedProduct = productRepository.save(product);

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
