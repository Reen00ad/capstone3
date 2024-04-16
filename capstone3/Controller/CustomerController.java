package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.Customer;
import com.example.capstone3.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/get")
    public ResponseEntity getAllCustomers(){
        return ResponseEntity.status(200).body(customerService.getAllCustomers());
    }


    @PostMapping("/add")
    public ResponseEntity addCustomers(@RequestBody @Valid Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body(new ApiResponse("Customer Added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody @Valid Customer customers){
        customerService.updateCustomer(id,customers);
        return ResponseEntity.status(200).body(new ApiResponse( "Customer updated"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body(new ApiResponse("Customer deleted!"));
    }

}
