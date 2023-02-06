package com.recipebook.ws.service;

import com.recipebook.ws.entity.Stock;
import com.recipebook.ws.entity.User;
import com.recipebook.ws.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public List<User> retrieveAllUser(){
        log.info("Retrieving all user list in DB");
        List<User> users = userRepository.findAll();
        log.info("{} elements retrieved", users.size());
        return users;
    }

    public User retrieveUser(int id){
        log.info("Retrieving one user list with {} in id", id);
        User user = userRepository.findById(id);
        log.info("{} retrieved", user.getPseudo());
        return user;
    }

    public List<User> createUser(List<User> users) {
        log.info("create user in DB");
        return userRepository.saveAll(users);
    }


    public void deleteUser(List<Integer> id) {
        userRepository.deleteAllById(id);
        log.info("Deleting user list with {} in id", id);
    }

    public List<User> updateUser(List<User> user) {
        log.info("update user in DB");
        return userRepository.saveAll(user);
    }

}
