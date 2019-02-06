package net.codingstuffs.java.user_management.profile.implementation;

import net.codingstuffs.java.user_management.profile.Profile;
import net.codingstuffs.java.user_management.profile.ProfileType;
import net.codingstuffs.java.user_management.profile.UserProfile;

@Profile(ProfileType.ADMIN)
public class ImplAdmin implements UserProfile {

  @Override
  public ProfileType type() {
    System.out.println("Access level: Admin");
    return ProfileType.ADMIN;
  }
}
