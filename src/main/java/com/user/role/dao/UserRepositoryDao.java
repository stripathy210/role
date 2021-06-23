package com.user.role.dao;

import com.user.role.entities.User;
import com.user.role.exception.UserException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

@Repository
public class UserRepositoryDao {
  private ConcurrentHashMap<String , User> userMap = new ConcurrentHashMap<>();

  public void add(String userId, User user) throws UserException{
    if (ObjectUtils.isEmpty(userId)) {
      throw new UserException("Invalid Id");
    }
    userMap.put(userId, user);
  }

  public User delete(String userId) throws UserException{
    if (ObjectUtils.isEmpty(userId) || !userMap.containsKey(userId)) {
      throw new UserException("Invalid Id");
    }
    User user = userMap.get(userId);
    userMap.remove(userId);
    return user;
  }

  public User getUser(String userId) throws UserException {
    if (ObjectUtils.isEmpty(userId) || !userMap.containsKey(userId)) {
      throw new UserException("Invalid Id");
    }
    return userMap.get(userId);

  }

  public List<User> getUsers() throws UserException {
    List<User> users = new ArrayList<>();
    for (Map.Entry<String, User> entry : userMap.entrySet()) {
        users.add(entry.getValue());
    }

    return users;

  }

}
