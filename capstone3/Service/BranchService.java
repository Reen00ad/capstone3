package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Branch;
import com.example.capstone3.Model.Driver;
import com.example.capstone3.Model.Laundry;
import com.example.capstone3.Model.Order;
import com.example.capstone3.Repository.BranchRepository;
import com.example.capstone3.Repository.DriverRepository;
import com.example.capstone3.Repository.LaundryRepository;
import com.example.capstone3.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {
    private final BranchRepository branchRepository;
    private final LaundryRepository laundryRepository;
    private final OrderRepository orderRepository;


    public List<Branch> getBranch() {
        return branchRepository.findAll();
    }

        public void addBranch( Integer LaundryId, Branch branch) {
           Laundry laundry = laundryRepository.findLaundryById(LaundryId);
        if (laundry == null) {
            throw new ApiException("LaundryId not found");
        }
        branch.setLaundry(laundry);
        branchRepository.save(branch);
    }
    public void updateBranch(Integer id, Branch branch) {
        Branch branch1 = branchRepository.findBranchById(id);
        if (branch1 == null) {
            throw new ApiException("id not found");
        }
        branch1.setDistrict(branch.getDistrict());
        branch1.setStreet(branch.getStreet());
        branchRepository.save(branch1);

    }

    public void deleteBranch(Integer id) {
        Branch branch1 = branchRepository.findBranchById(id);
        if (branch1 == null) {
            throw new ApiException("id not found");
        }
        branchRepository.delete(branch1);
    }


    //-----------------------   end crud   ------------------------------




    //-----------------------   1 endPoint   ------------------------------

    public void updateStatus(Integer orderId ) {
        Order order1 = orderRepository.findOrderById(orderId);
        if (order1 == null) {
            throw new ApiException("order id not found");
        }

            if (order1.getStatus().equalsIgnoreCase("waiting")) {
                order1.setStatus("accepted");
                orderRepository.save(order1);
            } else if (order1.getStatus().equalsIgnoreCase("received stuff")) {
                order1.setStatus("Delivered");
                orderRepository.save(order1);

            }



    }}
