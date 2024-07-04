package com.example.btvn_crud_restcontroller.Sevice;

import com.example.btvn_crud_restcontroller.Model.User;
import com.example.btvn_crud_restcontroller.Request.UserRequest;

import java.util.List;


public interface UserService {

    User addUser(User user);
    List<UserRequest> getList();

    User userDetail(int id);

    User updateUser(int id, UserRequest userDAO);

    String deleteUser(int id);
}
