package com.example.green_room.service;

import com.example.green_room.entity.Roles;
import com.example.green_room.entity.Users;
import com.example.green_room.payload.request.SignInRequest;
import com.example.green_room.payload.request.SignUpRequest;
import com.example.green_room.repository.UserRepository;
import com.example.green_room.service.imp.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceImp {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;


    @Override
    public boolean checkLogin(SignInRequest signInRequest){

        Users user = userRepository.findByEmail(signInRequest.getEmail());
        return passwordEncoder.matches(signInRequest.getPassword(),user.getPassword());

    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest){

        Roles role = new Roles();
        role.setId(signUpRequest.getRoleId());

        Users user = new Users();
        user.setUsername(signUpRequest.getUsername());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setRole(role);

        try{
            userRepository.save(user);
            return true;
        }catch (Exception e){
            System.out.println("Error insert user: " + e.getMessage());
            return false;
        }

    }

}
