package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Branch;
import com.example.capstone3.Model.Laundry;
import com.example.capstone3.Model.Owner;
import com.example.capstone3.Model.ServiceLaundry;
import com.example.capstone3.Repository.BranchRepository;
import com.example.capstone3.Repository.LaundryRepository;
import com.example.capstone3.Repository.ServiceLaundryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceLaundryService {

    private final ServiceLaundryRepository serviceLaundryRepository;
    private final LaundryRepository laundryRepository;
    private final BranchRepository branchRepository;

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

    public void  assignBranchToServiceLaundry(Integer branch_id,Integer serviceLaundry_id){
        Branch b=branchRepository.findBranchById(branch_id);
        ServiceLaundry sl=serviceLaundryRepository.findServiceLaundryById(serviceLaundry_id);

        if(b ==null || sl==null){
            throw new ApiException("cannot assign");
        }

        sl.setBranch(b);

        serviceLaundryRepository.save(sl);
    }



}
