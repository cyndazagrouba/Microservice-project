package com.ecommerce.orderservice.controllers;

import com.ecommerce.orderservice.entities.Order;
import com.ecommerce.orderservice.repositories.OrderRepository;
import com.ecommerce.orderservice.services.OrderService;
import com.ecommerce.orderservice.services.StripeService;
import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final StripeService stripeService;

    @Autowired
    public OrderController(OrderService orderService, StripeService stripeService) {
        this.orderService = orderService;
        this.stripeService = stripeService;
    }

    @PostMapping("/")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Order>> searchOrders(@RequestParam(name = "keyword", required = false) String keyword) {
        List<Order> orders = orderService.searchOrders(keyword);
        return ResponseEntity.ok(orders);
    }

    //@PostMapping("/pay/{id}")
    //public ResponseEntity<String> pay(@PathVariable(value = "id")  int order) {
        // Call Stripe payment processing method
    //  Stripe.apiKey ="sk_test_51Mh9fPDJjqsVZX1ZIYe5ugXUyeaqDIisghTY7UGpHotBsb1GmtqK1Xys7h014JERx84BEts4CM0RwolYJK5c3hOM00YASyBqsk";
    //   double prix= OrderRepository.findPricByFacture(order);
    //   ResponseEntity<String> responseEntity = stripeService.chargeCard(prix);
    //   if (responseEntity.getStatusCode() == HttpStatus.OK) {
            // Update payment status in database
    //      orderService.updatePaymentStatus(order);
    //    }
    //   return responseEntity;
    // }

}