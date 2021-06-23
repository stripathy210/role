package com.user.role.controller.service;

import com.user.role.dao.UserRepositoryDao;
import com.user.role.entities.RoleType;
import com.user.role.entities.User;
import com.user.role.exception.UserException;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import wiremock.org.apache.commons.lang3.EnumUtils;

@Component
@AllArgsConstructor
public class UserService {
  private final String USER_NOT_FOUND_EXCEPTION = "User Not Found ";
  private final String ROLE_NOT_FOUND_EXCEPTION = "Role Not Found ";

  private final UserRepositoryDao userRepositoryDao;

  public String addUser(User user) throws UserException{
    String userId = UUID.randomUUID().toString();
    user.setUserId(userId);
    userRepositoryDao.add(userId, user);
    return userId;
  }

  public String editRole(String userId, String roleType) throws UserException {

    if (!EnumUtils.isValidEnum(RoleType.class, roleType)) {
      throw new UserException(ROLE_NOT_FOUND_EXCEPTION);
    }

    User user = userRepositoryDao.getUser(userId);
    user.setRoleType(RoleType.valueOf(roleType));

    return user.getUserId();
  }

  public User deleteUser(String userId) throws UserException{
    return userRepositoryDao.delete(userId);
  }

  public User getUser(String userId) throws UserException{
    return userRepositoryDao.getUser(userId);
  }

  public List<User> bulkGet(String ownerId) throws UserException{
    User user = userRepositoryDao.getUser(ownerId);

    if (user.getRoleType() != RoleType.OWNER) {
      throw new UserException("Invalid Permission");
    }

    return userRepositoryDao.getUsers();
  }
}
