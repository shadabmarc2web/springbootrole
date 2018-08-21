package com.marc2web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marc2web.demo.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{
 public User findByEmail(String email);
}