package com.ITP_Project.fullstackbe.service;

import com.ITP_Project.fullstackbe.controller.request.UserLoginRequest;
import com.ITP_Project.fullstackbe.controller.response.AuthenticationResponse;
import com.ITP_Project.fullstackbe.model.User;
import com.ITP_Project.fullstackbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public AuthenticationResponse authenticateUser(UserLoginRequest request){

        User user = userRepository.findByEmailAndPassword(request.getEmail(),request.getPassword()).orElse(null);

                if(user == null){
                    return new AuthenticationResponse(null,false);
                }
return new AuthenticationResponse(user.getId(),true);
    }
}
