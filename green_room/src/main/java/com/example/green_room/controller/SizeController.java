package com.example.green_room.controller;

import com.example.green_room.dto.SizeDTO;
import com.example.green_room.payload.ResponseData;
import com.example.green_room.service.imp.SizeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/size")
public class SizeController {

    @Autowired
    SizeServiceImp sizeServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> insertSize(@RequestParam String sizeName){

        ResponseData responseData = new ResponseData();
        if(sizeServiceImp.insertSize(sizeName)){
            responseData.setData(true);
        }else {
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){

        ResponseData responseData = new ResponseData();
        List<SizeDTO> listSize = sizeServiceImp.getAll();
        if(!listSize.isEmpty()){
            responseData.setData(listSize);
        }else{
            responseData.setData(null);
            responseData.setSuccess(false);
        }

        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

}
