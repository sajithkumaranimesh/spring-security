package com.security_example.repository;

import com.security_example.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
    Users findByUsername(String username);
}
