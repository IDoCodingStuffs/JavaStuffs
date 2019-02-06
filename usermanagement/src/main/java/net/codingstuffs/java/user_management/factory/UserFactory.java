package net.codingstuffs.java.user_management.factory;

import java.io.Serializable;
import java.time.LocalDate;
import javax.ws.rs.Produces;
import net.codingstuffs.java.user_management.model.User;

public class UserFactory implements Serializable {

  @Produces
  public User getUser() {
    return new User("Bob", "bob@bob.bob", LocalDate.now(), LocalDate.MAX);
  }
}
