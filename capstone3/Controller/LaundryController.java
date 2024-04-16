package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.Laundry;
import com.example.capstone3.Service.LaundryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/laundry")
public class LaundryController {

    private final LaundryService laundryService;


    @GetMapping("/get")
    public ResponseEntity getAllLaundry(){

        return ResponseEntity.status(200).body(laundryService.getAllLaundry());
    }


    @PostMapping("/add")
    public ResponseEntity addLaundry(@RequestBody @Valid Laundry laundry){

        laundryService.addLaundry(laundry);
        return ResponseEntity.status(200).body(new ApiResponse("Laundry added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateLaundry(@PathVariable Integer id,@RequestBody @Valid Laundry laundry){
        laundryService.updateLaundry(id, laundry);
        return ResponseEntity.status(200).body(new ApiResponse("Laundry added"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLaundry(@PathVariable Integer id){
        laundryService.deleteLaundry(id);
        return ResponseEntity.status(200).body(new ApiResponse("Laundry deleted"));
    }


}
