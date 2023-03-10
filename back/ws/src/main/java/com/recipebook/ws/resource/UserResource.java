package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.User;
import com.recipebook.ws.repository.UserRepository;
import com.recipebook.ws.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ResourceUrlConst.USER_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserResource {
    private final UserRepository userRepository;

    private final UserService userService;

    @GetMapping
    public List<User> retrieveAllUser(){
        log.info("WS called");
        return userService.retrieveAllUser();
    }

    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable int id){
        return userService.retrieveUser(id);
    }


    @PostMapping
    public List<User> createUsers(@RequestBody List<User> users){
        log.info("WS called");
        return userService.createUsers(users);
    }

    @DeleteMapping
    public void deleteUsersById(@RequestBody List<Integer> ids) {
        userService.deleteUsersById(ids);
    }

    @PatchMapping
    public List<User> updateUsers(@RequestBody List<User> users) {
        return userService.updateUsers(users);
    }

}