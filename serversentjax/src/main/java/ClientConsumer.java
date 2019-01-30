import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.SseEventSource;

public class ClientConsumer {

  public static final Client CLIENT = ClientBuilder.newClient();
  public static final WebTarget WEB_TARGET = CLIENT.target(ServerMock.CONTEXT
      + ServerMock.BASE_PATH);

  public static void main(String[] args) {
    consume();
  }

  private static void consume() {
    try (final SseEventSource sseEventSource = SseEventSource
        .target(WEB_TARGET).build()) {

      sseEventSource.register(System.out::println);
      sseEventSource.open();

      for (int i = 0; i < 5; i++) {
        System.out.println("     ");
        for (int j = 0; j < 5; j++) {
          WEB_TARGET.request().post(Entity.json("event " + j));
        }
        Thread.sleep(1000);
      }

      CLIENT.close();

      System.out.println("All messages consumed");
    }
    catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}
