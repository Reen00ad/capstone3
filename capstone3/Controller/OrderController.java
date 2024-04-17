package com.example.capstone3.Controller;

import com.example.capstone3.Api.ApiResponse;
import com.example.capstone3.Model.Orders;
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
    public ResponseEntity addOrders(@RequestBody @Valid Orders orders){
        orderService.addOrder(orders);
        return ResponseEntity.status(200).body(new ApiResponse("Orders Added"));

    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateOrder(@PathVariable Integer id, @RequestBody @Valid Orders orders){
        orderService.updateOrder(id, orders);
        return ResponseEntity.status(200).body(new ApiResponse( "orders updated"));
    }

    //
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(200).body(new ApiResponse("order deleted!"));
    }

    //-----------------------   end crud   ------------------------------

//    @PutMapping("/assign/{orderid}/{servicelaundryid}")
//    public ResponseEntity assignOrderToServiceLaundry(@PathVariable Integer orderid,@PathVariable Integer servicelaundryid){
//        orderService.assignOrderToServiceLaundry(orderid,servicelaundryid);
//        return ResponseEntity.status(200).body(new ApiResponse("assign done"));
//    }





}
