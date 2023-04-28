package com.ITP_Project.fullstackbe.controller;

import com.ITP_Project.fullstackbe.exception.UserNotFoundException;
import com.ITP_Project.fullstackbe.model.User;
import com.ITP_Project.fullstackbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser)
    {
       Optional<User> userOptional =  userRepository.findByEmail(newUser.getEmail());
       if(userOptional.isPresent()){
           return  null;
       }
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setPassword((newUser.getPassword()));
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setAddress(newUser.getAddress());
                    user.setMobile(newUser.getMobile());
                    return userRepository.save(user);

                }).orElseThrow(()-> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "user with id "+id+" has been deleted successfully.";
    }

}
