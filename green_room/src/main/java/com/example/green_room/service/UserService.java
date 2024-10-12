package com.example.green_room.service;


import com.example.green_room.dto.UserDTO;
import com.example.green_room.entity.Users;
import com.example.green_room.repository.UserRepository;
import com.example.green_room.service.imp.RoleServiceImp;
import com.example.green_room.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    RoleServiceImp roleServiceImp;

    @Override
    public List<UserDTO> getAll(){

        List<Users> listUser = userRepository.findAll();
        List<UserDTO> listUserDTO = new ArrayList<>();

        for(Users user : listUser){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUsername(user.getUsername());
            userDTO.setEmail(user.getEmail());
            userDTO.setPassword(user.getPassword());
            listUserDTO.add(userDTO);
        }

        return listUserDTO;
    }

    @Override
    public Users getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public UserDTO getByIdDTO(int id) {
        return convertToDTO(userRepository.findById(id));
    }

    @Override
    public UserDTO convertToDTO(Users user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setAddress(user.getAddress());
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhoneNumbers(user.getPhoneNumbers());
        userDTO.setRole(user.getRole().getId());
        userDTO.setCreatedDate(user.getCreatedDate());
        return userDTO;
    }


}
