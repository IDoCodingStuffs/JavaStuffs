package net.codingstuffs.java.serverside_recipe.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.enterprise.inject.Model;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Model
public class User implements Serializable {
  @NotBlank
  @Size (min=4, max=15, message = "Name should be 4 to 15 characters long")
  private String name;

  @Email (message = "Invalid e-mail")
  @NotBlank (message = "Please enter an email")
  private String email;

  @PastOrPresent (message = "Creation date cannot be in the future")
  @NotNull (message = "Creation date cannot be null")
  private LocalDate creationDate;

  @Future(message = "Expiration date should be a future date")
  @NotNull (message = "Expiration date cannot be null")
  private LocalDate expirationDate;

  public LocalDate getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDate creationDate) {
    this.creationDate = creationDate;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate) {
    this.expirationDate = expirationDate;
  }

  public User(){
  }

  public User(@NotBlank String name,
      @Email(message = "Invalid e-mail") @NotBlank(message = "Please enter an email") String email,
      @PastOrPresent(message = "Creation date cannot be in the future") LocalDate creationDate,
      LocalDate expirationDate) {
    this.name = name;
    this.email = email;
    this.creationDate = creationDate;
    this.expirationDate = expirationDate;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User{" +
        "name='" + name + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
