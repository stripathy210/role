package com.user.role.controller.rest;

import com.user.role.controller.service.UserService;
import com.user.role.entities.RoleType;
import com.user.role.entities.User;
import com.user.role.exception.UserException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class UserController implements UserControllerIf{

  private final UserService userService;

  @Override
  @PostMapping(value = "/add")
  @Consumes(MediaType.APPLICATION_JSON)
  public String addUser(@RequestBody User user) throws UserException {
    return userService.addUser(user);
  }

  @Override
  @PutMapping(value = "/{userId}/{roleType}")
  public String editRole(@PathVariable String userId, @PathVariable  String roleType) throws UserException {
    return userService.editRole(userId, roleType);
  }


  @Override
  @DeleteMapping(value = "/{userId")
  public User deleteUser(@PathVariable String userId) throws UserException {
    return userService.deleteUser(userId);
  }

  @Override
  @GetMapping(value = "/all/{ownerId}")
  public List<User> getAllUsers(@PathVariable String ownerId) throws UserException {
    return userService.bulkGet(ownerId);
  }

}
