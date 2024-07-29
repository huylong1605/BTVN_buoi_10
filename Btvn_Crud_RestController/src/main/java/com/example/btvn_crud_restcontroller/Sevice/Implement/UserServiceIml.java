package com.example.btvn_crud_restcontroller.Sevice.Implement;

import com.example.btvn_crud_restcontroller.Model.User;
import com.example.btvn_crud_restcontroller.Repository.UserRepository;
import com.example.btvn_crud_restcontroller.Request.UserRequest;
import com.example.btvn_crud_restcontroller.Request.UserWithParameterRequest;
import com.example.btvn_crud_restcontroller.Sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Component("UserServiceIml")
public class UserServiceIml implements UserService {

    @Autowired
    private UserRepository userRepository;
    public static final List<User> userList = new ArrayList<>();
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
   /* @Override
    public User addUser(User user) {
         User user1 = new User();
         user1.setUserName(user.getUserName());
         user1.setUserAge((user.getUserAge()));
         userRepository.save(user1);
        return user;
    }
*/

    @Override
    @Transactional
    public User addUser(UserRequest userRequest) {
        User user1 = new User();
        user1.setUserName(userRequest.getUserRequest());
        user1.setUserAge((userRequest.getAge()));
        userRepository.save(user1);

        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9\\+_-]+(\\.[A-Za-z0-9\\+_-]+)*@"
                + "[^-][A-Za-z0-9\\+-]+(\\.[A-Za-z0-9\\+-]+)*(\\.[A-Za-z]{2,})$";

        if(patternMatches(userRequest.getEmailRequest(), regexPattern)){
            user1.setEmail(userRequest.getEmailRequest());
            userRepository.save(user1);
        }else {
            try {
                throw new Exception("Email loi");
            }catch (Exception e){
                throw new RuntimeException();
            }
        }
        return user1;
    }

    @Override
    public List<UserRequest> getList() {
      List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserRequest(user.getUserName(), user.getUserAge(), user.getEmail())).collect(Collectors.toList());
    }

    @Override
    public User userDetail(int id) {
        User user = userRepository.findById(id).orElseThrow();
        return user;
    }

    @Override
    public User updateUser(int id, UserRequest userDAO) {
        User user = userRepository.findById(id).orElseThrow();
         user.setUserName(userDAO.getUserRequest());
         user.setUserAge(userDAO.getAge());
         user.setEmail(userDAO.getEmailRequest());
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(int id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return "Da xoa thanh cong Id "+id;
    }

    @Override
    public List<User> getUserSmallThan2() {
        return userRepository.getUserSmallThan2();
    }

    @Override
    public List<User> getUserSmallThanWithParameter(UserWithParameterRequest request) {
        return userRepository.getUserSmallThanWithParameter(request.getUserWithParamId());
    }
@Transactional
    @Override
    public User updateWithModify(int id) {
        userRepository.updateWithModify(id);
        return userRepository.findById(id).orElseThrow();
    }
}
