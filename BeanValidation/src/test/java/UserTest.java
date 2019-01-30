import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {
  private static Validator validator;

  @BeforeClass
  public static void setUpClass() {
    validator = Validation.buildDefaultValidatorFactory()
        .getValidator();
  }

  @Test
  public void validUser() {
    User user = new User(
      "bob",
      "bob@bob.com",
      asList(42,43));

    Set<ConstraintViolation<User>> cv = validator
        .validate(user);
    assertTrue(cv.isEmpty());
  }

  @Test
  public void invalidName() {
    User user = new User(
        "",
        "bob@bob.com",
        asList(42,43));

    Set<ConstraintViolation<User>> cv = validator
        .validate(user);
    assertEquals(cv.size(), 1);
  }

  @Test
  public void invalidEmail() {
    User user = new User(
        "Bob",
        "bob.bob.com",
        asList(42,43));

    Set<ConstraintViolation<User>> cv = validator
        .validate(user);
    assertEquals(cv.size(), 1);
  }

  @Test
  public void invalidId() {
    User user = new User(
        "Bob",
        "bob@bob.com",
        asList(42,43, -1, -1, -1));

    Set<ConstraintViolation<User>> cv = validator
        .validate(user);
    assertEquals(cv.size(), 3);
  }
}

