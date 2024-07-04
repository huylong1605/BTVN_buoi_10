package com.example.btvn_crud_restcontroller.RestController;

import com.example.btvn_crud_restcontroller.Model.User;
import com.example.btvn_crud_restcontroller.Request.UserRequest;
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
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
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
}
