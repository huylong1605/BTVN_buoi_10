package com.example.btvn_crud_restcontroller.RestController;

import com.example.btvn_crud_restcontroller.Model.User;
import com.example.btvn_crud_restcontroller.Request.UserRequest;
import com.example.btvn_crud_restcontroller.Request.UserWithParameterRequest;
import com.example.btvn_crud_restcontroller.Sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1")
public class UserRestController {

    @Autowired
    @Qualifier(value = "UserServiceIml")
    private UserService userService;
    @PostMapping("add_user")
    public User addUser(@RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }

    @GetMapping("list_user")
    public List<UserRequest> listUser(){
        return userService.getList();
    }

    @GetMapping("user_detail/{id}")
    public User userDetail(@PathVariable("id") int id){
          return userService.userDetail(id);
    }

    @DeleteMapping("delete_user/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

    @PutMapping("update_user/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody UserRequest userDAO){
        return userService.updateUser(id, userDAO);
    }

    @GetMapping("list_user_2")
    public List<User> listUser2(){
        return userService.getUserSmallThan2();
    }


    @GetMapping("list_user_3")
    public List<User> getUserSmallThanWithParameter(@RequestBody UserWithParameterRequest request){
        return userService.getUserSmallThanWithParameter(request);
    }

    @PutMapping("update_modify/{id}")
    public User updateUserWithModify(@PathVariable("id") int id){
        return userService.updateWithModify(id);
    }
}
