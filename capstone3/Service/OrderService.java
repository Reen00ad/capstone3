package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Orders;
import com.example.capstone3.Model.ServiceLaundry;
import com.example.capstone3.Repository.CustomerRepository;

import com.example.capstone3.Repository.OrderRepository;

import com.example.capstone3.Repository.ServiceLaundryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ServiceLaundryRepository serviceLaundryRepository;

    public List<Orders> getAllOrder(){
        return orderRepository.findAll();

    }

    public void addOrder(Orders orders){
        orderRepository.save(orders);
    }




    public void updateOrder(Integer id, Orders orders){
        Orders o=orderRepository.findOrderById(id);
        if(o==null){
            throw new ApiException("orders not found");
        }
        o.setDeliveryPrice(orders.getDeliveryPrice());
        o.setTotalPrice(orders.getTotalPrice());
        o.setNationalAddressOfCustomer(orders.getNationalAddressOfCustomer());
        o.setDistrictOfLaundry(orders.getDistrictOfLaundry());
        o.setStreetOfLaundry(orders.getStreetOfLaundry());
        o.setRating(orders.getRating());
        o.setComment(orders.getComment());

        orderRepository.save(o);

    }


    public void deleteOrder(Integer id){
        Orders orders =orderRepository.findOrderById(id);
        if(orders ==null){
            throw new ApiException("orders not found");
        }
        orderRepository.delete(orders);
    }

    //-----------------------   end crud   ------------------------------



    public List<String> getComments(){
        return orderRepository.findAllComments();
    }


}
