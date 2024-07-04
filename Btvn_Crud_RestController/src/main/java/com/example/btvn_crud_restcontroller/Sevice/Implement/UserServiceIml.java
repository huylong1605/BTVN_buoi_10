package com.example.btvn_crud_restcontroller.Sevice.Implement;

import com.example.btvn_crud_restcontroller.Model.User;
import com.example.btvn_crud_restcontroller.Repository.UserRepository;
import com.example.btvn_crud_restcontroller.Request.UserRequest;
import com.example.btvn_crud_restcontroller.Sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component("UserServiceIml")
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;
    public static final List<User> user_list = new ArrayList<>();
    @Override
    public User addUser(User user) {
         User user1 = new User();
         user1.setUser_name(user.getUser_name());
         user1.setUser_age((user.getUser_age()));
         userRepository.save(user1);
        return user;
    }

    @Override
    public List<UserRequest> getList() {
      List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserRequest(user.getUser_name(), user.getUser_age())).collect(Collectors.toList());
    }

    @Override
    public User userDetail(int id) {
        User user = userRepository.findById(id).orElseThrow();
        return user;
    }

    @Override
    public User updateUser(int id, UserRequest userDAO) {
        User user = userRepository.findById(id).orElseThrow();
         user.setUser_name(userDAO.getUserName());
         user.setUser_age(userDAO.getAge());
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return "Da xoa thanh cong Id "+id;
    }
}
