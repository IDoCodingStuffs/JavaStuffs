import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class JsonBUser {

  public static void main(String[] args) throws Exception {
    User user = new User("Bob", "bob@bob.bob");

    Jsonb jsonb = JsonbBuilder.create();
    String jsonUser = jsonb.toJson(user);
    User u = jsonb.fromJson(jsonUser, User.class);

    jsonb.close();

    System.out.println("json: " + jsonUser);
    System.out.println("user: " + u);
  }
}
