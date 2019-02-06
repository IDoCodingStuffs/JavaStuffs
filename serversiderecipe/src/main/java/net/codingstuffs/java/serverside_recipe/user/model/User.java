package net.codingstuffs.java.serverside_recipe.user.model;

import java.io.Serializable;
import javax.enterprise.inject.Model;

@Model
public class User implements Serializable {
  private String name;
  private String email;

  public User(){
  }

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
