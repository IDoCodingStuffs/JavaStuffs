import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("userValidator")
public class UserValidator implements Validator<User> {
  @Override
  public void validate(FacesContext facesContext, UIComponent uiComponent, User user)
  throws ValidatorException {
    if(!user.getEmail().contains("@")){
      throw new ValidatorException(new FacesMessage(null, "Bad email"));
    }
  }
}
