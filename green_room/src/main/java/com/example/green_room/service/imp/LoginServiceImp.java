package com.example.green_room.service.imp;

import com.example.green_room.dto.UserDTO;
import com.example.green_room.payload.request.SignInRequest;
import com.example.green_room.payload.request.SignUpRequest;

import java.util.List;

public interface LoginServiceImp {

    boolean checkLogin(SignInRequest signInRequests);
    boolean addUser(SignUpRequest signUpRequest);

}
