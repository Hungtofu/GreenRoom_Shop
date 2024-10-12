package com.example.green_room.service.imp;

import com.example.green_room.dto.PlantTypeDTO;
import com.example.green_room.entity.PlantTypes;

import java.util.List;
import java.util.Set;

public interface PlantTypeServiceImp {

    boolean insertPlantType(String typeName);
    List<PlantTypeDTO> getAll();
    PlantTypes getById(int id);
    PlantTypeDTO getByIdDTO(int id);
    PlantTypeDTO convertToDTO(PlantTypes plantType);
    List<PlantTypeDTO> convertToListDTO(List<PlantTypes> listPlantType);

}
