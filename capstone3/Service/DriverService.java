package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Driver;
import com.example.capstone3.Repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;


    public List<Driver> getDriver() {
        return driverRepository.findAll();
    }

    public void addDriver(Driver driver) {

        driverRepository.save(driver);
    }

    public void updateDriver(Integer id, Driver driver) {
        Driver driver1 = driverRepository.findDriversById(id);
        if (driver1 == null) {
            throw new ApiException("id not found");
        }
        driver1.setEmail(driver.getEmail());
        driver1.setPassword(driver.getPassword());
        driver1.setPhoneNumber(driver.getPhoneNumber());
        driverRepository.save(driver1);
    }

    public void deleteDriver(Integer id) {
        Driver driver = driverRepository.findDriversById(id);
        if (driver == null) {
            throw new ApiException("id not found");
        }
        driverRepository.delete(driver);
    }


}
