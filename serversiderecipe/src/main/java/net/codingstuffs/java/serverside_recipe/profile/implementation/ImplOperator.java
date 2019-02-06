package net.codingstuffs.java.serverside_recipe.profile.implementation;

import javax.enterprise.inject.Default;
import net.codingstuffs.java.serverside_recipe.profile.Profile;
import net.codingstuffs.java.serverside_recipe.profile.ProfileType;
import net.codingstuffs.java.serverside_recipe.profile.UserProfile;

@Profile(ProfileType.OPERATOR)
@Default
public class ImplOperator implements UserProfile {

  @Override
  public ProfileType type() {
    System.out.println("Access level: Operator");
    return ProfileType.OPERATOR;
  }
}
