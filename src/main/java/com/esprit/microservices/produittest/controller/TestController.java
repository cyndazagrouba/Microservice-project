package com.esprit.microservices.produittest.controller;

import com.esprit.microservices.produittest.response.BlogResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/blogs/{productId}")
    public List<BlogResponse> getTestBlogs(@PathVariable Long productId) {
        // Simule la liste des blogs pour le produit spécifié
        List<BlogResponse> testBlogs = new ArrayList<>();
        testBlogs.add(new BlogResponse(1L, "Blog 1", "Image", "Sponsor", "Contenu du blog", LocalDateTime.now(), LocalDateTime.now()));
        testBlogs.add(new BlogResponse(2L, "Blog 2", "Image", "Sponsor2", "Contenu ", LocalDateTime.now(), LocalDateTime.now()));


        return testBlogs;
    }
}
