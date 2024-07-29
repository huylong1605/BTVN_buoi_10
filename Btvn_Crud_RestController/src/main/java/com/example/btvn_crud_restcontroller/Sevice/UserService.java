package com.example.btvn_crud_restcontroller.Sevice;

import com.example.btvn_crud_restcontroller.Model.User;
import com.example.btvn_crud_restcontroller.Request.UserRequest;
import com.example.btvn_crud_restcontroller.Request.UserWithParameterRequest;

import java.util.List;


public interface UserService {

    User addUser(UserRequest userRequest);

    List<UserRequest> getList();

    User userDetail(int id);

    User updateUser(int id, UserRequest userDAO);

    String deleteUser(int id);

    List<User> getUserSmallThan2();

    List<User> getUserSmallThanWithParameter(UserWithParameterRequest request);

    User updateWithModify(int id);
}
