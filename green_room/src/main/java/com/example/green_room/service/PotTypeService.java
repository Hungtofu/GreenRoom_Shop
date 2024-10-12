package com.example.green_room.service;

import com.example.green_room.dto.PotTypeDTO;
import com.example.green_room.entity.PotTypes;
import com.example.green_room.repository.PotTypeRepository;
import com.example.green_room.service.imp.PotTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PotTypeService implements PotTypeServiceImp {

    @Autowired
    PotTypeRepository potTypeRepository;

    @Override
    public boolean insertPotType(String typeName) {

        try {
            PotTypes potType = new PotTypes();
            potType.setTypeName(typeName);
            potType.setCreatedDate(Timestamp.from(Instant.now()));
            potTypeRepository.save(potType);
            return true;
        }catch(Exception e){
            System.out.println("Error insert pot type: " + e.getMessage());
            return false;
        }
    }

    public List<PotTypeDTO> convertToListDTO(List<PotTypes> listPotType){

        List<PotTypeDTO> listPotTypeDTO = new ArrayList<>();
        for(PotTypes potType : listPotType){
            listPotTypeDTO.add(convertToDTO(potType));
        }
        return listPotTypeDTO;
    }

    public PotTypeDTO convertToDTO (PotTypes potType){

        return new PotTypeDTO(potType.getId(), potType.getTypeName());
    }


    @Override
    public List<PotTypeDTO> getAll() {
        return convertToListDTO(potTypeRepository.findAll());
    }


}
