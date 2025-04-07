package com.cws.user.service.services;

import com.cws.user.service.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getSingleUser(String userId);

    void deleteUser(String userId);

    User updateUser(User user,String userId);
}
