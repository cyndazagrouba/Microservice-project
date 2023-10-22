package com.esprit.microservices.produittest.services;


import com.esprit.microservices.produittest.feignclient.BlogFeignClient;
import com.esprit.microservices.produittest.model.Product;
import com.esprit.microservices.produittest.repository.ProductRepository;
import com.esprit.microservices.produittest.response.BlogResponse;
import com.esprit.microservices.produittest.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductService {


    @Autowired
    private ProductRepository productRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private BlogFeignClient blogFeignClient;
    private final EmailService emailService;

    @Autowired
    public ProductService(ProductRepository productRepository, EmailService emailService) {
        this.productRepository = productRepository;
        this.emailService = emailService;
    }

    public Product addProduct(String productName, String description, int price, int reference, int quantity, String imageFileName) {
        // Enregistrez les informations du produit, y compris le nom du fichier
        Product newProduct = new Product();
        newProduct.setProductName(productName);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setReference(reference);
        newProduct.setQuantity(quantity);
        newProduct.setImage(imageFileName); // Stockez le nom du fichier

        // Enregistrez le produit dans la base de données
        productRepository.save(newProduct);

        // Vous pouvez également envoyer une notification par e-mail ici si nécessaire

        return newProduct;
    }

    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    //all avec pagination
    public List<Product> getAllProducts(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("reference"));
        Page<Product> productPage = productRepository.findAll(pageable);
        return productPage.getContent();
    }

    public Product getProductById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElse(null);
    }


    public boolean updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setProductName(updatedProduct.getProductName());
            productToUpdate.setDescription(updatedProduct.getDescription());
            productToUpdate.setPrice(updatedProduct.getPrice());
            productToUpdate.setReference(updatedProduct.getReference());
            productToUpdate.setQuantity(updatedProduct.getQuantity());

            productRepository.save(productToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteProduct(Long id) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    //recherche par 3 critéres
    public List<Product> getAllSearchProduct(
            String productName,
            Integer reference,
            String description,
            Integer minPrice,
            Integer maxPrice) {
        String jpql = "SELECT p FROM Product p " +
                "WHERE (:productName IS NULL OR LOWER(p.productName) LIKE LOWER(:productName)) " +
                "AND (:reference IS NULL OR p.reference = :reference) " +
                "AND (:description IS NULL OR LOWER(p.description) LIKE LOWER(:description)) " +
                "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
                "AND (:maxPrice IS NULL OR p.price <= :maxPrice) " +
                "ORDER BY p.reference ASC";

        TypedQuery<Product> typedQuery = entityManager.createQuery(jpql, Product.class);

        typedQuery.setParameter("productName", productName);
        typedQuery.setParameter("reference", reference);
        typedQuery.setParameter("description", description);
        typedQuery.setParameter("minPrice", minPrice);
        typedQuery.setParameter("maxPrice", maxPrice);

        return typedQuery.getResultList();
    }

    public List<Product> filterProductsByPrice(int maxPrice) {
        return productRepository.findByPriceLessThan(maxPrice);
    }

    public List<Product> filterProductsByQuantity(int minQuantity) {
        return productRepository.findByQuantityGreaterThan(minQuantity);
    }

    public ProductResponse getBlogByIdProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductResponse productResponse = new ProductResponse();

            // Affectez les propriétés du produit au produit de réponse
            productResponse.setId(product.getId());
            productResponse.setProductName(product.getProductName());
            productResponse.setDescription(product.getDescription());
            // Assurez-vous d'affecter d'autres propriétés comme le prix, la référence, la quantité, etc.

            // Utilisez FeignClient pour obtenir la réponse du blog
            ResponseEntity<BlogResponse> blogResponseEntity = blogFeignClient.getBlogByProductId(id);

            if (blogResponseEntity.getStatusCode().is2xxSuccessful()) {
                productResponse.setBlogResponse(blogResponseEntity.getBody());
            }

            return productResponse;
        } else {
            // Gérez le cas où le produit n'a pas été trouvé
            // Vous pouvez renvoyer une réponse d'erreur appropriée ou renvoyer null, par exemple.
            return null;
        }




    }}