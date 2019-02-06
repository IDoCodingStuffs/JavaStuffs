package net.codingstuffs.java.serverside_recipe.user.profile.implementation;

import net.codingstuffs.java.serverside_recipe.user.profile.Profile;
import net.codingstuffs.java.serverside_recipe.user.profile.ProfileType;
import net.codingstuffs.java.serverside_recipe.user.profile.UserProfile;

@Profile(ProfileType.ADMIN)
public class ImplAdmin implements UserProfile {

  @Override
  public ProfileType type() {
    System.out.println("Access level: Admin");
    return ProfileType.ADMIN;
  }
}
