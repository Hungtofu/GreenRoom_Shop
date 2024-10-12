package com.example.green_room.service;

import com.example.green_room.dto.PlantTypeDTO;
import com.example.green_room.entity.PlantTypes;
import com.example.green_room.repository.PlantTypeRepository;
import com.example.green_room.service.imp.PlantTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PlantTypeService implements PlantTypeServiceImp {

    @Autowired
    PlantTypeRepository plantTypeRepository;

    @Override
    public boolean insertPlantType(String typeName) {

        try {
            PlantTypes plantTypes = new PlantTypes();
            plantTypes.setTypeName(typeName);
            plantTypes.setCreatedDate(Timestamp.from(Instant.now()));
            plantTypeRepository.save(plantTypes);
            return true;
        }catch (Exception e){
            System.out.println("Error insert type plant: " + e.getMessage());
            return false;
        }

    }

    @Override
    public List<PlantTypeDTO> convertToListDTO(List<PlantTypes> listPlantType){

        List<PlantTypeDTO> listPlantTypeDTO = new ArrayList<>();
        for(PlantTypes typePlant: listPlantType){
            listPlantTypeDTO.add(convertToDTO(typePlant));
        }
        return listPlantTypeDTO;

    }

    @Override
    public PlantTypeDTO convertToDTO(PlantTypes plantType){
        PlantTypeDTO plantTypeDTO = new PlantTypeDTO();
        plantTypeDTO.setId(plantType.getId());
        plantTypeDTO.setTypeName(plantType.getTypeName());
        plantTypeDTO.setCreatedDate(plantType.getCreatedDate());
        return plantTypeDTO;
    }

    @Override
    public List<PlantTypeDTO> getAll() {

        return convertToListDTO(plantTypeRepository.findAll());

    }

    @Override
    public PlantTypes getById(int id) {
        return plantTypeRepository.findById(id);
    }

    @Override
    public PlantTypeDTO getByIdDTO(int id) {
        return convertToDTO(plantTypeRepository.findById(id));
    }


}
