package com.ecommerce.orderservice.repositories;

import com.ecommerce.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface OrderRepository extends JpaRepository<Order, Integer> {

   // @Transactional
   // @Query(value="select p.amount from orders", nativeQuery = true)
   // static double findPricByFacture(int id);

}



