package com.ITP_Project.fullstackbe.controller;

import com.ITP_Project.fullstackbe.controller.request.UserLoginRequest;
import com.ITP_Project.fullstackbe.controller.response.AuthenticationResponse;
import com.ITP_Project.fullstackbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/authenticate")
    public AuthenticationResponse userLogin(@RequestBody UserLoginRequest userLoginRequest){

        System.out.println(" ==username and passeord ["+userLoginRequest.getEmail()+"] ["+userLoginRequest.getPassword()+"] ");

        return userService.authenticateUser(userLoginRequest);

    }
}
