package com.example.green_room.controller;

import com.example.green_room.dto.PotTypeDTO;
import com.example.green_room.payload.ResponseData;
import com.example.green_room.service.imp.PotTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/potType")
public class PotTypeController {

    @Autowired
    PotTypeServiceImp potTypeServiceImp;

    @PostMapping("/insert")
    public ResponseEntity<?> insertPotType(@RequestParam String potTypeName){

        ResponseData responseData = new ResponseData();
        if(potTypeServiceImp.insertPotType(potTypeName)){
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
        List<PotTypeDTO> listPotType = potTypeServiceImp.getAll();
        if(!listPotType.isEmpty()){
            responseData.setData(listPotType);
        }else{
            responseData.setData(false);
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
