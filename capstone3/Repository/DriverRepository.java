package com.example.capstone3.Repository;

import com.example.capstone3.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {

    Driver findDriversById(Integer id);

}
