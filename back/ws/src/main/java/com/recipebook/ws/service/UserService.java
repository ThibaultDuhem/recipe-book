package com.recipebook.ws.service;

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

    public List<User> createUsers(List<User> users) {
        log.info("create user in DB");
        return userRepository.saveAll(users);
    }


    public void deleteUsersById(List<Integer> ids) {
        userRepository.deleteAllById(ids);
        log.info("Deleting user lists with {} in id", ids);
    }

    public List<User> updateUsers(List<User> users) {
        log.info("update users in DB");
        return userRepository.saveAll(users);
    }

}
