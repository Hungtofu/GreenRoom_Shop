package com.example.green_room.controller;

import com.example.green_room.dto.PlantTypeDTO;
import com.example.green_room.payload.ResponseData;
import com.example.green_room.service.imp.PlantServiceImp;
import com.example.green_room.service.imp.PlantTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/plantType")
public class PlantTypeController {

    @Autowired
    PlantTypeServiceImp plantTypeServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> insertPlantType(@RequestParam String plantTypeName){

        ResponseData responseData = new ResponseData();
        if(plantTypeServiceImp.insertPlantType(plantTypeName)){
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
        List<PlantTypeDTO> listPlantType = plantTypeServiceImp.getAll();
        if(!listPlantType.isEmpty()){
            responseData.setData(listPlantType);
        }else {
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
