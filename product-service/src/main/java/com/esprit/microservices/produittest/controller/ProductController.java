package com.esprit.microservices.produittest.controller;

import com.esprit.microservices.produittest.model.Product;
import com.esprit.microservices.produittest.repository.ProductRepository;
import com.esprit.microservices.produittest.services.EmailService;
import com.esprit.microservices.produittest.services.ProductService;
import io.micrometer.core.lang.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EmailService emailService;

    @PostMapping("/add")
    public ResponseEntity<String> addProductWithImage(
            @RequestParam("productName") String productName,
            @RequestParam("description") String description,
            @RequestParam("price") int price,
            @RequestParam("reference") int reference,
            @RequestParam("quantity") int quantity,
            @RequestParam("productImage") MultipartFile productImage) {

        String originalFilename = productImage.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();

        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png", "gif");

        if (!allowedExtensions.contains(fileExtension)) {
            return new ResponseEntity<>("Le fichier n'est pas une image valide.", HttpStatus.BAD_REQUEST);
        }

        // Vous pouvez stocker uniquement le nom du fichier dans le modèle de produit
        String imageFileName = originalFilename;

        // Enregistrez le reste des informations du produit dans votre base de données
        Product newProduct = new Product();
        newProduct.setProductName(productName);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setReference(reference);
        newProduct.setQuantity(quantity);
        newProduct.setImage(imageFileName);

        productRepository.save(newProduct);

        return new ResponseEntity<>("Le produit a été ajouté avec succès.", HttpStatus.OK);
    }




    //methode all avec pagination
    @GetMapping("/all")
    public List<Product> getAllProducts(@RequestParam int page, @RequestParam int pageSize) {
        List<Product> products = productService.getAllProducts(page, pageSize);
        return products;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        if (productService.updateProduct(id, updatedProduct)) {
            return ResponseEntity.ok("Product updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }
    //delete product
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        if (productService.deleteProduct(id)) {
            return ResponseEntity.ok("Product deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }
    //recherche avec 3 critéres et filtre avec prix min et max
    @GetMapping("/allSearchProduct")
    public List<Product> getAllSearchProduct(
            @RequestParam @Nullable String productName,
            @RequestParam @Nullable Integer reference,
            @RequestParam @Nullable String description,
            @RequestParam @Nullable Integer minPrice,
            @RequestParam @Nullable Integer maxPrice) {
        return productService.getAllSearchProduct(productName, reference, description, minPrice, maxPrice);
    }

    @GetMapping("/filter/price")
    public ResponseEntity<List<Product>> filterProductsByPrice(@RequestParam int maxPrice) {
        List<Product> filteredProducts = productService.filterProductsByPrice(maxPrice);
        return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
    }

    @GetMapping("/filter/quantity")
    public ResponseEntity<List<Product>> filterProductsByQuantity(@RequestParam int minQuantity) {
        List<Product> filteredProducts = productService.filterProductsByQuantity(minQuantity);
        return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
    }

}
