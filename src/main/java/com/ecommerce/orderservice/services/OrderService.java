package com.ecommerce.orderservice.services;


import com.ecommerce.orderservice.entities.Order;
import com.ecommerce.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(int id, Order updatedOrder) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order orderToUpdate = existingOrder.get();
            orderToUpdate.setProductId(id);
            orderToUpdate.setQuantity(updatedOrder.getQuantity());
            orderToUpdate.setTypeModalite(updatedOrder.getTypeModalite());
            orderToUpdate.setOrderDate(updatedOrder.getOrderDate());
            orderToUpdate.setEmailUser(updatedOrder.getEmailUser());
            orderToUpdate.setOrderStatus(updatedOrder.getOrderStatus());
            orderToUpdate.setDeliveryAddress(updatedOrder.getDeliveryAddress());
            orderToUpdate.setAmount(updatedOrder.getAmount());
            return orderRepository.save(orderToUpdate);
        } else {
            throw new EntityNotFoundException("Order with ID " + id + " not found");
        }
    }

    public void deleteOrder(int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Order with ID " + id + " not found");
        }
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with ID " + id + " not found"));
    }


    public List<Order> searchOrders(String keyword) {
        Specification<Order> spec = (Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (keyword == null || keyword.isEmpty()) {
                return criteriaBuilder.conjunction();
            } else {
                String pattern = "%" + keyword + "%";
                Predicate predicate = criteriaBuilder.or(
                        criteriaBuilder.like(root.get("deliveryAddress"), pattern),
                        criteriaBuilder.like(root.get("emailUser"), pattern)
                );
                return predicate;
            }
        };
        return orderRepository.findAll((Sort) spec);
    }

    //public void updatePaymentStatus(int productId) {
    //    Order = orderRepository.findById(Order).get();
    //    Order.setorderStatus(true);
    //    orderRepository.save(Order);
    // }


}
