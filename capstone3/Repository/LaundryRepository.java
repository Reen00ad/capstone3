package com.example.capstone3.Repository;

import com.example.capstone3.Model.Laundry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaundryRepository extends JpaRepository<Laundry,Integer> {

    Laundry findLaundryById(Integer id);

}
