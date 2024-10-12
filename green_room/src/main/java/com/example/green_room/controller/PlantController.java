package com.example.green_room.controller;

import com.example.green_room.dto.PlantDetailDTO;
import com.example.green_room.dto.PlantListDTO;
import com.example.green_room.payload.ResponseData;
import com.example.green_room.payload.request.PlantRequest;
import com.example.green_room.service.imp.PlantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/plant")
public class PlantController {

    @Autowired
    PlantServiceImp plantServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> insertPlant(@RequestPart PlantRequest plantRequest,
                                         @RequestPart MultipartFile[] files){


        ResponseData responseData = new ResponseData();
        boolean isSuccess = plantServiceImp.insertPlant(plantRequest, files);
        if(isSuccess){
            responseData.setData(true);
        }else {
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @GetMapping("/getPlantList")
    public ResponseEntity<?> getPlantList(){

        ResponseData responseData = new ResponseData();
        List<PlantListDTO> listPlant = plantServiceImp.getList();
        responseData.setData(listPlant);
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @PostMapping("/getPlantDetail/{plantId}")
    public ResponseEntity<?> getPlantDetail(@PathVariable("plantId") int plantId){

        ResponseData responseData = new ResponseData();
        responseData.setData(plantServiceImp.getPlantDetail(plantId));

        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @PostMapping("/category/{categoryId}")
    public ResponseEntity<?> getByCategories(@PathVariable("categoryId") int categoryId){

        ResponseData responseData = new ResponseData();

        List<PlantListDTO> listPlantList = new ArrayList<>();
        if(categoryId == -2){
            listPlantList = plantServiceImp.getList();
        } else if (categoryId == -1) {
            listPlantList = plantServiceImp.getNewArrival();
        } else if(categoryId == 0){
            listPlantList = plantServiceImp.getRare();
        } else {
            listPlantList = plantServiceImp.getByCategory(categoryId);
        }

        responseData.setData(listPlantList);

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


}
