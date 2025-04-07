package com.cws.user.service.services.impl;

import com.cws.user.service.entities.User;
import com.cws.user.service.exception.ResourceNotFoundException;
import com.cws.user.service.repository.UserRepository;
import com.cws.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        String userId = UUID.randomUUID().toString();
        user.setUid(userId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user with given id not found"));
        return user;
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user with given id not found"));
        userRepository.delete(user);
    }

    @Override
    public User updateUser(User user, String userId) {

        User user1 = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user with given id not found"));
        user1.setAbout(user.getAbout());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        User savedUser = userRepository.save(user1);
        return savedUser;
    }

}
