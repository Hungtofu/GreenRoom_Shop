package com.example.green_room.controller;

import com.example.green_room.dto.OrderItemDTO;
import com.example.green_room.payload.ResponseData;
import com.example.green_room.repository.OrderItemRepository;
import com.example.green_room.service.imp.OrderItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    @Autowired
    OrderItemServiceImp orderItemServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> insertOrderItem(@RequestParam int orderId,
                                             @RequestParam int productId,
                                             @RequestParam int quantity,
                                             @RequestParam BigDecimal price){

        ResponseData responseData = new ResponseData();
        if(orderItemServiceImp.insertOrderItem(orderId, productId, quantity, price)){
            responseData.setData(true);
        }else{
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){

        ResponseData responseData = new ResponseData();
        List<OrderItemDTO> listOrderItem = orderItemServiceImp.getAll();
        if(!listOrderItem.isEmpty()){
            responseData.setData(listOrderItem);
        }else{
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
