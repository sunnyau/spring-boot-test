package com.example.test.springboottest.service;

import com.example.test.springboottest.model.UserView;
import com.example.test.springboottest.repository.User;
import com.example.test.springboottest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserView> getAll() {
        List<User> userList = userRepository.findAll();
        Function<User,UserView> convertUserToUserView = user -> UserView.builder().id(user.getId()).name(user.getName()).title(user.getTitle()).build();
        return userList.stream().map(convertUserToUserView).collect(toList());
    }
}
