package com.example.capstone3.Repository;

import com.example.capstone3.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order findOrderById(Integer id);


    List<Order> findOrderByServiceLaundriesAAndLaundryId(Integer laundryid);

    @Query("select o.comment from Order o where o.comment is not null ")
    List<String> findAllComments();

    @Query("select a from Order a where a.status='Waiting'")
    List<Order> findOrders();

//    @Modifying
//    @Transactional
//    @Query("UPDATE Order p SET p.status='Shipment has arrived at warehouse' WHERE p.id= :orderId")
    //   void updateOrderStatusById(Integer orderId);

    List<Order> findOrdersByCustomerId(Integer customerId);

    List<Order> findOrdersByDriverId(Integer deliverId);
}
