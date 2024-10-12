package com.example.green_room.service.imp;

import com.example.green_room.dto.RoleDTO;
import com.example.green_room.entity.Roles;

import java.util.List;
import java.util.Set;

public interface RoleServiceImp {

    List<RoleDTO> getAll();
    Roles getById(int id);
    RoleDTO getByIdDTO(int id);
    RoleDTO convertToDTO(Roles role);
    List<RoleDTO> convertToListDTO(List<Roles> listRole);

}
