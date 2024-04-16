package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Branch;
import com.example.capstone3.Model.Order;
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

    public List<Order> getAllOrder(){
        return orderRepository.findAll();

    }

    public void addOrder(Order order){
        orderRepository.save(order);
    }


//    public void addOrder(Integer CId , Integer SId){
//   // B   ServiceLaundry sl=serviceLaundryRepository.findServiceLaundryById();
////        if(sl==null){
////        throw new ApiException("service laundry found");
////        }
//
//        Customer c=customerRepository.findCustomersById(CId);
//        if (c == null) {
//            throw new ApiException("Wrong id");
//        }
//
//        Order O = new Order();
//        O.setStreet();
//
//        orderRepository.save(O);
//    }


    public void updateOrder(Integer id,Order order){
        Order o=orderRepository.findOrderById(id);
        if(o==null){
            throw new ApiException("order not found");
        }
        o.setDeliveryPrice(order.getDeliveryPrice());
        o.setTotalPrice(order.getTotalPrice());
        o.setNationalAddress(order.getNationalAddress());
        o.setDistrict(order.getDistrict());
        o.setStreet(order.getStreet());
        o.setRating(order.getRating());
        o.setComment(order.getComment());

        orderRepository.save(o);

    }


    public void deleteOrder(Integer id){
        Order order=orderRepository.findOrderById(id);
        if(order==null){
            throw new ApiException("order not found");
        }
        orderRepository.delete(order);
    }

    public void assignOrderToServiceLaundry(Integer orderid,Integer servicelaundryid , Integer q){
        Order o=orderRepository.findOrderById(orderid);
        ServiceLaundry sl=serviceLaundryRepository.findServiceLaundryById(servicelaundryid);

        if(o==null || sl==null){
            throw new ApiException("can't assign");
        }

        o.getServiceLaundries().add(sl);
       o.setDistrict(sl.getBranch().getDistrict());
       o.setStreet(sl.getBranch().getStreet());


        orderRepository.save(o);
        sl.s
        //serviceLaundryRepository.save(sl);
    }


}
