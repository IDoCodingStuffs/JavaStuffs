package net.codingstuffs.java.user_management.model.validation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class UserValidator {
  public void validate() {
    FacesContext
        .getCurrentInstance()
        .addMessage(
            null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "User data valid!", "")
        );
  }
}
