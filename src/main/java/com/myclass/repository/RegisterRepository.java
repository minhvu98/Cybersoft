package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.User;

public interface RegisterRepository extends JpaRepository<User, Integer>{

}
