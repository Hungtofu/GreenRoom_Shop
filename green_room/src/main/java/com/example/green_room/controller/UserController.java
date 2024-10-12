package com.example.green_room.controller;

import com.example.green_room.dto.UserDTO;
import com.example.green_room.entity.Users;
import com.example.green_room.payload.ResponseData;
import com.example.green_room.service.imp.UserServiceImp;
import com.example.green_room.util.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    JwtHelper jwtHelper;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllUser(){

        return new ResponseEntity<>(userServiceImp.getAll(), HttpStatus.OK);

    }

    @PostMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){

        ResponseData responseData = new ResponseData();
        UserDTO userDTO = userServiceImp.getByIdDTO(id);
        responseData.setData(userDTO);
        return new ResponseEntity<>(responseData,HttpStatus.OK);

    }

    @PostMapping("/getUser")
    public ResponseEntity<?> getUser(@RequestHeader("Authorization") String jwt){

        ResponseData responseData = new ResponseData();
        responseData.setData(jwtHelper.getIdFromJwtToken(jwt));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
