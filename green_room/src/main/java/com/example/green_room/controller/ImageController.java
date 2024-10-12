package com.example.green_room.controller;

import com.example.green_room.dto.ImageDTO;
import com.example.green_room.payload.ResponseData;
import com.example.green_room.service.imp.ImageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageServiceImp imageServiceImp;

//    @PostMapping("/insert")
//    public ResponseEntity<?> insert(@RequestParam int productId,
//                                        @RequestParam MultipartFile file){
//
//        ResponseData responseData = new ResponseData();
//        if(imageServiceImp.insertImage(productId, file)){
//            responseData.setData(true);
//        }else{
//            responseData.setData(false);
//            responseData.setSuccess(false);
//        }
//        return new ResponseEntity<>(responseData, HttpStatus.OK);
//    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){

        ResponseData responseData = new ResponseData();
//        List<ImageDTO> listImage = imageServiceImp.getAll();
//        if(!listImage.isEmpty()){
//            responseData.setData(listImage);
//        }else{
//            responseData.setData(null);
//            responseData.setSuccess(false);
//        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

}
