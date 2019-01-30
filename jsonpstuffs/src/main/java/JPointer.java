import java.io.IOException;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonPointer;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;


public class JPointer {

  public static void main(String[] args) throws IOException {
    try (InputStream inputStream = JPointer.class.getClassLoader()
        .getResourceAsStream("user.json");
        JsonReader jsonReader = Json.createReader(inputStream)) {

      JsonStructure jsonStructure = jsonReader.read();
      JsonPointer jsonPointer = Json.createPointer("/user/profile");
      JsonValue jsonValue = jsonPointer.getValue(jsonStructure);
      System.out.println("profile: " + jsonValue);
    }
  }
}
