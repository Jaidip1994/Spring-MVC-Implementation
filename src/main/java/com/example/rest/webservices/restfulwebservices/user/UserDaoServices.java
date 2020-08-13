package com.example.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoServices {
  private static List<User> users = new ArrayList<>();
  private static int usersCount = 3;

  static {
    users.add(new User(1, "Jai", new Date()));
    users.add(new User(2, "Adam", new Date()));
    users.add(new User(3, "Eve", new Date()));
  }

  public List<User> findAll() {
    return users;
  }

  public User save(User user) {
    if (user.getId() == null) {
      user.setId(++usersCount);
    }
    users.add(user);
    return user;
  }

  public User findOne(int id) {
    for (User user : users) {
      if (user.getId() == id) {
        return user;
      }
    }
    return null;
  }

  public User deleteByID(int id) {
    for (User user : users) {
      if (user.getId() == id) {
        users.remove(user);
        return user;
      }
    }
    return null;
  }
}
