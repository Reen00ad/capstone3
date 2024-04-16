package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.Driver;
import com.example.capstone3.Service.DriverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/get")
    public ResponseEntity getDriver(){
        return ResponseEntity.status(200).body(driverService.getDriver());
    }

    @PostMapping("/add")
    public ResponseEntity addDriver(@RequestBody @Valid Driver driver){
        driverService.addDriver(driver);
        return ResponseEntity.ok().body(new ApiResponse("Driver added"));

    }
    @PutMapping("/Update/{id}")
    public ResponseEntity UpdateDriver(@PathVariable Integer id, @RequestBody @Valid Driver driver){
        driverService.updateDriver(id,driver);
        return ResponseEntity.ok().body(new ApiResponse("Driver Update"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDriver(@PathVariable Integer id){
        driverService.deleteDriver(id);
        return ResponseEntity.ok().body(new ApiResponse("Driver Deleted"));

    }
}
