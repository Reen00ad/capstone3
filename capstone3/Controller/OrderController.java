package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.Order;
import com.example.capstone3.Service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private  final OrderService orderService;


    @GetMapping("/get")
    public ResponseEntity getAllOrders(){
        return ResponseEntity.status(200).body(orderService.getAllOrder());

    }

    @PostMapping("/add")
    public ResponseEntity addOrders(@RequestBody @Valid Order order){
        orderService.addOrder(order);
        return ResponseEntity.status(200).body(new ApiResponse("Order Added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @RequestBody @Valid Order order){
        orderService.updateOrder(id,order);
        return ResponseEntity.status(200).body(new ApiResponse( "order updated"));
    }

    //
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(200).body(new ApiResponse("order deleted!"));
    }

    @PutMapping("/assign/{orderid}/{servicelaundryid}")
    public ResponseEntity assignOrderToServiceLaundry(@PathVariable Integer orderid,@PathVariable Integer servicelaundryid){
        orderService.assignOrderToServiceLaundry(orderid,servicelaundryid);
        return ResponseEntity.status(200).body(new ApiResponse("assign done"));
    }





}
