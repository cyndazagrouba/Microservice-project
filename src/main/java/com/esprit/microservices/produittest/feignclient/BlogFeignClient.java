package com.esprit.microservices.produittest.feignclient;

import com.esprit.microservices.produittest.response.BlogResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "blog-service",url =  "http://localhost:8040") // Le nom correspond au nom du microservice "Blog"
public interface BlogFeignClient {
   // @GetMapping("/blog/product/{id}")
   // List<BlogResponse> getBlogsForProduct(@PathVariable Long id);

    @GetMapping("/test/blogs/{productId}")
    List<BlogResponse> getTestBlogs(@PathVariable Long productId);
    @GetMapping("/blog/product/{id}")
    public ResponseEntity<BlogResponse> getBlogByProductId(@PathVariable("id") Long id);

}
