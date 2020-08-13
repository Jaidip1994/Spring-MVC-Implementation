package com.example.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResources {
  @Autowired private UserDaoServices userDaoServices;

  @GetMapping(value = "/users")
  public List<User> retrieveAllUsers() {
    return userDaoServices.findAll();
  }

  @GetMapping(value = "/users/{id}")
  public User retrieveUser(@PathVariable int id) {
    User user = userDaoServices.findOne(id);
    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }
    return user;
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = userDaoServices.save(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteByUserID(@PathVariable int id) {
    User user = userDaoServices.deleteByID(id);
    if (user == null) {
      throw new UserNotFoundException("id-" + id);
    }
  }
}
