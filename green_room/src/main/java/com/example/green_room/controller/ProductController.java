package com.example.green_room.controller;

import com.example.green_room.payload.ResponseData;
import com.example.green_room.payload.request.GetVariantRequest;
import com.example.green_room.payload.request.ProductRequest;
import com.example.green_room.service.imp.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImp productServiceImp;

    @PostMapping(value = "/insert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> insert(@RequestPart ProductRequest productRequest){

        ResponseData responseData = new ResponseData();
//        if(productServiceImp.insertProduct(productRequest)){
//            responseData.setData(true);
//        }else{
//            responseData.setData(false);
//            responseData.setSuccess(false);
//        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){

        ResponseData responseData = new ResponseData();

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @PostMapping("/getVariant")
    public ResponseEntity<?> getBySizePotType(@RequestBody GetVariantRequest getVariantRequest){
        ResponseData responseData = new ResponseData();
        if(getVariantRequest.getPotTypeId() != null){
            responseData.setData(productServiceImp.getBySizePotType(getVariantRequest.getPlantId(),
                    getVariantRequest.getSizeId(),
                    getVariantRequest.getPotTypeId()));
        } else {
            responseData.setData(productServiceImp.getBySize(getVariantRequest.getPlantId(),
                    getVariantRequest.getSizeId()));
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
