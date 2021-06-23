package com.user.role.entities;

import java.util.List;
import java.util.StringJoiner;
import lombok.Data;

@Data
public class User {
  private String userId;
  private String userName;
  private String email;
  private RoleType roleType;
  private List<Company> companies;

  @Override
  public String toString() {
    return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
        .add("userId='" + userId + "'")
        .add("userName='" + userName + "'")
        .add("email='" + email + "'")
        .add("roleType=" + roleType)
        .add("companyList=" + companies)
        .toString();
  }
}
