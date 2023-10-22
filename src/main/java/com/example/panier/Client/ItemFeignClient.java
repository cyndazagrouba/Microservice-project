package com.example.panier.Client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "item-service") // Provide the name of the target service
public interface ItemFeignClient {

    @GetMapping("/items/{itemId}")
    String getItemName(@PathVariable("itemId") Long itemId);
}
