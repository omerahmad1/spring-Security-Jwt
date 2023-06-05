package com.spring.security.jwt.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.jwt.Entities.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);
}
