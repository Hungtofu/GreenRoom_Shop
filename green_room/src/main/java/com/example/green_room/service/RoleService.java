package com.example.green_room.service;

import com.example.green_room.dto.RoleDTO;
import com.example.green_room.entity.Roles;
import com.example.green_room.repository.RoleRepository;
import com.example.green_room.service.imp.RoleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleService implements RoleServiceImp {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getAll() {
        return convertToListDTO(roleRepository.findAll());
    }

    @Override
    public Roles getById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public RoleDTO getByIdDTO(int id) {
        return convertToDTO(roleRepository.findById(id));
    }

    @Override
    public RoleDTO convertToDTO(Roles role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setRoleName(role.getRoleName());
        roleDTO.setCreatedDate(role.getCreatedDate());
        return roleDTO;
    }

    @Override
    public List<RoleDTO> convertToListDTO(List<Roles> listRole) {
        List<RoleDTO> listRoleDTO = new ArrayList<>();
        for(Roles role : listRole){
            listRoleDTO.add(convertToDTO(role));
        }
        return listRoleDTO;
    }
}
