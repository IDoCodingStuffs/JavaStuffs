import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("userConverter")
public class UserConverter implements Converter<User> {

  @Override
  public String getAsString(FacesContext facesContext, UIComponent uiComponent, User user) {
    return user.getName() + "|" + user.getEmail();
  }

  @Override
  public User getAsObject(FacesContext facesContext, UIComponent uiComponent, String string) {
    return new User(string.substring(0, string.indexOf("|")),
        string.substring(string.indexOf("|") + 1));
  }
}
