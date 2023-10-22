package com.esprit.microservices.produittest.controller;

import com.esprit.microservices.produittest.feignclient.BlogFeignClient;
import com.esprit.microservices.produittest.model.Product;
import com.esprit.microservices.produittest.repository.ProductRepository;
import com.esprit.microservices.produittest.response.BlogResponse;
import com.esprit.microservices.produittest.response.ProductResponse;
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
    @Autowired
    private BlogFeignClient blogFeignClient;

//ajout produit avec envoi du mail
@PostMapping("/add")
public ResponseEntity<String> addProduct(
        @RequestParam("productName") String productName,
        @RequestParam("description") String description,
        @RequestParam("price") int price,
        @RequestParam("reference") int reference,
        @RequestParam("quantity") int quantity,
        @RequestParam("productImage") MultipartFile productImage) {

    if (productImage != null) {
        String originalFilename = productImage.getOriginalFilename();
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
        List<String> allowedExtensions = Arrays.asList("jpg", "jpeg", "png", "gif");

        if (!allowedExtensions.contains(fileExtension)) {
            return new ResponseEntity<>("Le fichier n'est pas une image valide.", HttpStatus.BAD_REQUEST);
        }

        // Stockez uniquement le nom du fichier
        String imageFileName = originalFilename;

        // Appelez la méthode du service pour ajouter le produit
        productService.addProduct(productName, description, price, reference, quantity, imageFileName);

        // Envoyez une notification par e-mail si nécessaire
        String to = "emnaayachi2@gmail.com";
        String subject = "Nouveau produit ajouté";
        String message = "Un nouveau produit a été ajouté : " + productName + "\nRéférence : " + reference + "\nDescription : " + description;

        emailService.sendNotificationEmail(to, subject, message);

        return new ResponseEntity<>("Le produit a été ajouté avec succès.", HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Fichier d'image manquant.", HttpStatus.BAD_REQUEST);
    }
}


    //liste produit
    @GetMapping("/allproduct")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    //produit par id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //liste avec pagination
    @GetMapping("/all")
    public List<Product> getAllProducts(@RequestParam int page, @RequestParam int pageSize) {
        List<Product> products = productService.getAllProducts(page, pageSize);
        return products;
    }
    //update
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
    //recherche avec tous critéres et filtre avec prix min et max
    @GetMapping("/allSearchProduct")
    public List<Product> getAllSearchProduct(
            @RequestParam @Nullable String productName,
            @RequestParam @Nullable Integer reference,
            @RequestParam @Nullable String description,
            @RequestParam @Nullable Integer minPrice,
            @RequestParam @Nullable Integer maxPrice) {
        return productService.getAllSearchProduct(productName, reference, description, minPrice, maxPrice);
    }

    //filtre produit par max prix
    @GetMapping("/filter/price")
    public ResponseEntity<List<Product>> filterProductsByPrice(@RequestParam int maxPrice) {
        List<Product> filteredProducts = productService.filterProductsByPrice(maxPrice);
        return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
    }

    //flitre par min quantity
    @GetMapping("/filter/quantity")
    public ResponseEntity<List<Product>> filterProductsByQuantity(@RequestParam int minQuantity) {
        List<Product> filteredProducts = productService.filterProductsByQuantity(minQuantity);
        return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
    }
    //openfeign liste blog pour produit
//    @GetMapping("/{id}")
//    public ResponseEntity<ProductResponse> getBlogByIdProduct(@PathVariable Long id) {
//        ProductResponse productResponse = productService.getBlogByIdProduct(id);
//
//        if (productResponse != null) {
//            return ResponseEntity.ok(productResponse);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
   // }
}