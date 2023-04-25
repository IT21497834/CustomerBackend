package com.ITP_Project.fullstackbe.repository;

import com.ITP_Project.fullstackbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
}
