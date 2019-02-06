package net.codingstuffs.java.user_management.profile.implementation;

import javax.enterprise.inject.Default;
import net.codingstuffs.java.user_management.profile.Profile;
import net.codingstuffs.java.user_management.profile.ProfileType;
import net.codingstuffs.java.user_management.profile.UserProfile;

@Profile(ProfileType.OPERATOR)
@Default
public class ImplOperator implements UserProfile {

  @Override
  public ProfileType type() {
    System.out.println("Access level: Operator");
    return ProfileType.OPERATOR;
  }
}
