import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Stateful
public class UserBean {

  @PersistenceContext(unitName = "security-api-stuffs", type = PersistenceContextType.EXTENDED)
  private EntityManager entityManager;

  @RolesAllowed({Roles.ADMIN, Roles.OPERATOR})
  public void add(User user) {
    entityManager.persist(user);
  }

  @RolesAllowed({Roles.ADMIN})
  public void remove(User user) {
    entityManager.remove(user);
  }

  @RolesAllowed({Roles.ADMIN})
  public void update(User user) {
    entityManager.merge(user);
  }

  @PermitAll
  public List<User> get() {
    Query query = entityManager.createQuery("SELECT u FROM User as u");
    return query.getResultList();
  }
}
