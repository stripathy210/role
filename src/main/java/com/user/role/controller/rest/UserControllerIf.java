package com.user.role.controller.rest;

import com.user.role.entities.User;
import com.user.role.exception.UserException;
import java.util.List;

public interface UserControllerIf {

  String addUser(User user) throws UserException;
  String editRole(String userId, String roleType) throws UserException;

  User deleteUser(String userId) throws UserException;

  List<User> getAllUsers(String userId) throws UserException;

}
