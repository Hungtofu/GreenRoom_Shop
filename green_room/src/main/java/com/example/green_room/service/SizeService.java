package com.example.green_room.service;

import com.example.green_room.dto.SizeDTO;
import com.example.green_room.entity.Products;
import com.example.green_room.entity.Sizes;
import com.example.green_room.repository.SizeRepository;
import com.example.green_room.service.imp.SizeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Service
public class SizeService implements SizeServiceImp {

    @Autowired
    SizeRepository sizeRepository;

    @Override
    public boolean insertSize(String sizeName) {

        Sizes size = new Sizes();
        size.setSizeName(sizeName);
        size.setCreatedDate(Timestamp.from(Instant.now()));
        try {
            sizeRepository.save(size);
            return true;
        } catch (Exception e){
            System.out.println("Error insert size: " + e.getMessage());
            return false;
        }
    }

    public List<SizeDTO> convertToListDTO(List<Sizes> listSize){

        List<SizeDTO> listSizeDTO = new ArrayList<>();
        for(Sizes size: listSize){
            listSizeDTO.add(new SizeDTO(size.getId(), size.getSizeName()));
        }
        return listSizeDTO;

    }


    @Override
    public List<SizeDTO> getAll() {
        return convertToListDTO(sizeRepository.findAll());
    }





}
