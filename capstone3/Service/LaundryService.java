package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Laundry;
import com.example.capstone3.Model.Owner;
import com.example.capstone3.Repository.LaundryRepository;
import com.example.capstone3.Repository.OrderRepository;
import com.example.capstone3.Repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaundryService {

    private final LaundryRepository laundryRepository;
    private final OwnerRepository ownerRepository;


    public List<Laundry> getAllLaundry(){
        return laundryRepository.findAll();
    }

    public void addLaundry(Laundry laundry){
        laundryRepository.save(laundry);
    }

    public void updateLaundry(Integer id,Laundry laundry){
        Laundry l=laundryRepository.findLaundryById(id);
        if(l==null){
            throw new ApiException("laundry found");
        }

        l.setName(laundry.getName());
        l.setCommercialRegistertion(laundry.getCommercialRegistertion());
        l.setPhoneNumber(laundry.getPhoneNumber());
        l.setEmail(laundry.getEmail());

        laundryRepository.save(l);
    }

    public void deleteLaundry(Integer id){
        Laundry l=laundryRepository.findLaundryById(id);
        if(l==null){
            throw new ApiException("laundry found");
        }
        laundryRepository.delete(l);
    }

    //-----------------------   end crud   ------------------------------

    public void  assignOwnerToLaundry(Integer owner_id,Integer laundry_id){
        Owner o=ownerRepository.findOwnerById(owner_id);
        Laundry l=laundryRepository.findLaundryById(laundry_id);

        if(o ==null || l==null){
            throw new ApiException("cannot assign");
        }

        l.setOwner(o);

        laundryRepository.save(l);
    }

}
