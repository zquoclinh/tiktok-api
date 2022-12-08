package com.tiktok.server.controllers;

import com.tiktok.server.models.ResponseObject;
import com.tiktok.server.models.User;
import com.tiktok.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/Users")
public class UserController {

    //DI= dependency injection
    @Autowired
    private UserRepository repository;

    //getAllUsers
    @GetMapping("")
    List<User> getAllUsers(){
        return repository.findAll(); //where is data
    }

    //get detail user
    @GetMapping("/{id}")
    //let's return a object with: data, message, status
    ResponseEntity<ResponseObject> findById (@PathVariable Long id){
        Optional<User> foundUser = repository.findById(id);
        if(foundUser.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "query user successfully", foundUser)
            );
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("ok", "cannot find user with id = "+id, "")
            );
        }
    }

    //insert new user with post method
    //postman raw, json
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertUser(@RequestBody User newUser){
        //2 users must not have the same private info
        List<User> foundUsers = repository.findByFullName(newUser.getFullName().trim());
        if(foundUsers.size() > 0){
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "fullname already taken", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
          new ResponseObject("ok", "insert user successfully", repository.save(newUser))
        );
    }

    //update, upsert = update if found, otherwise insert
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateUser(@RequestBody User newUser, @PathVariable Long id){
        User updatedUser = repository.findById(id)
              .map(user -> {
                 user.setAvatar(newUser.getAvatar());
                 user.setBio(newUser.getBio());
                 user.setFacebookUrl(newUser.getFacebookUrl());
                 user.setFirstName(newUser.getFirstName());
                 user.setTick(newUser.isTick());
                 user.setFollowersCount(newUser.getFollowersCount());
                 user.setFullName(newUser.getFullName());
                 user.setInstagramUrl(newUser.getInstagramUrl());
                 user.setLastName(newUser.getLastName());
                 user.setYoutubeUrl(newUser.getYoutubeUrl());
                 user.setWebsiteUrl(newUser.getWebsiteUrl());
                 user.setTwitterUrl(newUser.getTwitterUrl());
                 user.setNikeName(newUser.getNikeName());
                 user.setLikesCount(newUser.getLikesCount());
                 return repository.save(user);
              }).orElseGet(() -> {
                  newUser.setId(id);
                  return repository.save(newUser);
                });

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "updated user successfully", updatedUser)
        );
    }

    //delete user => DELETE method
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteUser(@PathVariable Long id){
        boolean exists = repository.existsById(id);
        if (exists){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
              new ResponseObject("ok", "Deleted user","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("failed", "can not find user to delete","")
        );
    }

}
