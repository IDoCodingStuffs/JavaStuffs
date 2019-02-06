package net.codingstuffs.java.serverside_recipe.user.factory;

import java.io.Serializable;
import javax.ws.rs.Produces;
import net.codingstuffs.java.serverside_recipe.user.model.User;

public class UserFactory implements Serializable {

  @Produces
  public User getUser() {
    return new User("Bob", "bob@bob.bob");
  }
}
