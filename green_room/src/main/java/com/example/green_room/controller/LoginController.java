package com.example.green_room.controller;

import com.example.green_room.payload.ResponseData;
import com.example.green_room.payload.request.SignInRequest;
import com.example.green_room.payload.request.SignUpRequest;
import com.example.green_room.service.imp.LoginServiceImp;
import com.example.green_room.util.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    LoginServiceImp loginServiceImp;

    @Autowired
    JwtHelper jwtHelper;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody SignInRequest signInRequest){

        ResponseData responseData = new ResponseData();
        if( loginServiceImp.checkLogin(signInRequest)){
            String token = jwtHelper.generateToken(signInRequest.getEmail());
            responseData.setData(token);
        } else {
            responseData.setData("");
            responseData.setSuccess(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest){

        ResponseData responseData = new ResponseData();
        responseData.setData(loginServiceImp.addUser(signUpRequest));
        return new ResponseEntity<>(responseData, HttpStatus.OK);

    }
}
