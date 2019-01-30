import javax.annotation.Priority;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;
import javax.interceptor.Interceptor;

public class OrderedObserver {

  public static void main(String[] args){
    try(SeContainer container = SeContainerInitializer.newInstance()
    .initialize()){
      container
          .getBeanManager()
          .fireEvent(new StuffsEvent(
              "event: " + System.currentTimeMillis()
          ));
    }
  }

  public void thisEventBefore(
      @Observes @Priority(Interceptor.Priority.APPLICATION - 200)
      StuffsEvent event
  ){
    System.out.println("thisEventBefore: " + event.getVal());
  }

  public void thisEventAfter(
      @Observes @Priority(Interceptor.Priority.APPLICATION + 200)
          StuffsEvent event
  ){
    System.out.println("thisEventAfter: " + event.getVal());
  }
}
