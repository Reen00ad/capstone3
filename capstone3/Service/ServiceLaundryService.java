package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.*;
import com.example.capstone3.Repository.BranchRepository;
import com.example.capstone3.Repository.LaundryRepository;
import com.example.capstone3.Repository.OrderRepository;
import com.example.capstone3.Repository.ServiceLaundryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceLaundryService {

    private final ServiceLaundryRepository serviceLaundryRepository;
    private final LaundryRepository laundryRepository;
    private final BranchRepository branchRepository;
    private final OrderRepository orderRepository;

    public List<ServiceLaundry> getAllServiceLaundry(){
        return serviceLaundryRepository.findAll();
    }

    public void addServiceLaundry(ServiceLaundry serviceLaundry){
        serviceLaundryRepository.save(serviceLaundry);
    }


    public void updateServiceLaundry(Integer id, ServiceLaundry serviceLaundry){
        ServiceLaundry sl=serviceLaundryRepository.findServiceLaundryById(id);
        if(sl==null){
            throw new ApiException("service laundry found");
        }

        sl.setCategory(serviceLaundry.getCategory());
        sl.setName(serviceLaundry.getName());
        sl.setServiceType(serviceLaundry.getServiceType());
        sl.setPrice(serviceLaundry.getPrice());

        serviceLaundryRepository.save(sl);
    }

    public void deleteServiceLaundry(Integer id){
        ServiceLaundry sl=serviceLaundryRepository.findServiceLaundryById(id);
        if(sl==null){
            throw new ApiException("service laundry found");
        }
        serviceLaundryRepository.delete(sl);
    }

    //-----------------------   end crud   ------------------------------



    public void  assignBranchToServiceLaundry(Integer branch_id,Integer serviceLaundry_id){
        Branch b=branchRepository.findBranchById(branch_id);
        ServiceLaundry sl=serviceLaundryRepository.findServiceLaundryById(serviceLaundry_id);

        if(b ==null || sl==null){
            throw new ApiException("cannot assign");
        }

        sl.setBranch(b);

        serviceLaundryRepository.save(sl);
    }

    //-----------------------   1 endPoint   ------------------------------

    public List<Order> previousOrders(Integer laundryid) {
        ArrayList<Order> orders2 = new ArrayList<Order>();
        Laundry l=laundryRepository.findLaundryById(laundryid);
        if (l == null) {
            throw new ApiException("laundry id not found");
        }
        List<Order> orders3 = orderRepository.findOrderByServiceLaundriesAAndLaundryId(laundryid);
        if (orders3== null) {
            throw new ApiException(" orders not found");
        }
        for (Order orders1 : orders3) {
            if (orders1.getStatus().equalsIgnoreCase("Delivered")){
                orders2.add(orders1);
            }}

        return orders2;
    }

    //-----------------------   2 endPoint   ------------------------------


    public List<Order> currentOrders(Integer laundryid) {
        ArrayList<Order> orders2 = new ArrayList<>();
        Laundry l=laundryRepository.findLaundryById(laundryid);
        if (l == null) {
            throw new ApiException("laundry id not found");
        }
        List<Order> orders3 = orderRepository.findOrderByServiceLaundriesAAndLaundryId(laundryid);
        if (orders3== null) {
            throw new ApiException(" orders not found");
        }
        for (Order orders1 : orders3) {
            if (orders1.getStatus().equalsIgnoreCase("received stuff") || orders1.getStatus().equalsIgnoreCase("received to laundry")){
                orders2.add(orders1);
            }}

        return orders2;
    }




}
