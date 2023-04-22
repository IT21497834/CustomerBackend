package com.ITP_Project.fullstackbe.repository;

import com.ITP_Project.fullstackbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
