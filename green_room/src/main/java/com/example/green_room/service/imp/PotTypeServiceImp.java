package com.example.green_room.service.imp;

import com.example.green_room.dto.PotTypeDTO;
import com.example.green_room.entity.PotTypes;

import java.util.List;
import java.util.Set;

public interface PotTypeServiceImp {

    boolean insertPotType(String typeName);
    List<PotTypeDTO> getAll();

}
