package com.example.green_room.service.imp;

import com.example.green_room.dto.UserDTO;
import com.example.green_room.entity.Users;

import java.util.List;
import java.util.Set;

public interface UserServiceImp {

    List<UserDTO> getAll();
    Users getById(int id);
    UserDTO getByIdDTO(int id);
    UserDTO convertToDTO(Users user);

}
