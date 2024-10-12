package com.example.green_room.controller;

import com.example.green_room.dto.PlantTypeDTO;
import com.example.green_room.payload.ResponseData;
import com.example.green_room.service.imp.PlantTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/typePlant")
public class TypePlantController {

    @Autowired
    PlantTypeServiceImp typePlantServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> insertTypePlant(@RequestParam String typeName){
        ResponseData responseData = new ResponseData();
        if(typePlantServiceImp.insertPlantType(typeName)){
            responseData.setData(true);
        }else {
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        ResponseData responseData = new ResponseData();
        List<PlantTypeDTO> listTypePlant = typePlantServiceImp.getAll();
        if(!listTypePlant.isEmpty()){
            responseData.setData(listTypePlant);
        }else{
            responseData.setData(null);
            responseData.setSuccess(false);
        }

        return new ResponseEntity<>(responseData,HttpStatus.OK);
    }


}
