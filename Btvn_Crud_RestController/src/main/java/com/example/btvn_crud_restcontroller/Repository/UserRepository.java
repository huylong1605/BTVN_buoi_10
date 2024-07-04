package com.example.btvn_crud_restcontroller.Repository;

import com.example.btvn_crud_restcontroller.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
}
