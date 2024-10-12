package com.example.green_room.controller;

import com.example.green_room.payload.ResponseData;
import com.example.green_room.service.CartService;
import com.example.green_room.service.imp.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartServiceImp cartServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> insertCart(@RequestParam int userId){

        ResponseData responseData = new ResponseData();
        if(cartServiceImp.insertCart(userId)){
            responseData.setData(true);
        }else {
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCart(){

        ResponseData responseData = new ResponseData();
        responseData.setData(cartServiceImp.getAll());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestParam int userId, @RequestParam int productId, @RequestParam int quantity){

        ResponseData responseData = new ResponseData();
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
