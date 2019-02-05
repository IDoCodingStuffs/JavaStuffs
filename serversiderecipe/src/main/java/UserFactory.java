import java.io.Serializable;
import javax.ws.rs.Produces;

public class UserFactory implements Serializable {
  @Produces
  public User getUser() {
    return new User("Bob", "bob@bob.bob");
  }
}
