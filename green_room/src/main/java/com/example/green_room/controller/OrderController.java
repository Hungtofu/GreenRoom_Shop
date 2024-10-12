package com.example.green_room.controller;

import com.example.green_room.dto.OrderDTO;
import com.example.green_room.payload.ResponseData;
import com.example.green_room.service.imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImp orderServiceImp;


    @PostMapping("/insert")
    public ResponseEntity<?> insertOrder(@RequestParam int userId,
                                         @RequestParam String status,
                                         @RequestParam BigDecimal total){

        ResponseData responseData = new ResponseData();
        if(orderServiceImp.insertOrder(userId, status, total)){
            responseData.setData(true);
        }else {
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllOrder(){

        ResponseData responseData = new ResponseData();
        List<OrderDTO> listOrder = orderServiceImp.getall();
        if(!listOrder.isEmpty()){
            responseData.setData(listOrder);
        }else{
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
