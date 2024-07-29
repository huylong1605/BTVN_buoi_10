package com.example.btvn_crud_restcontroller.Repository;

import com.example.btvn_crud_restcontroller.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("select u from User u where u.userId <= 2")
    List<User> getUserSmallThan2();

    @Query("select u from User u where u.userId <= :valueSmallerId")
    List<User> getUserSmallThanWithParameter(int valueSmallerId);

    @Modifying
    @Query("update User u set u.userAge = 1 where u.userId = :id")
    void updateWithModify(int id);
}
