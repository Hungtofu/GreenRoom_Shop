package com.example.green_room.controller;

import com.example.green_room.dto.CartItemDTO;
import com.example.green_room.payload.ResponseData;
import com.example.green_room.service.imp.CartItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    @Autowired
    CartItemServiceImp cartItemServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> insertCartItem(@RequestParam int cartId,
                                            @RequestParam int productId,
                                            @RequestParam int quantity){

        ResponseData responseData = new ResponseData();
        if(cartItemServiceImp.insertCartItem(cartId, productId, quantity)){
            responseData.setData(true);
        }else {
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllCartItem(){

        ResponseData responseData = new ResponseData();
        responseData.setData(cartItemServiceImp.getALl());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
