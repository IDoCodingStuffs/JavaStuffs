package net.codingstuffs.java.serverside_recipe.profile.implementation;

import net.codingstuffs.java.serverside_recipe.profile.Profile;
import net.codingstuffs.java.serverside_recipe.profile.ProfileType;
import net.codingstuffs.java.serverside_recipe.profile.UserProfile;

@Profile(ProfileType.ADMIN)
public class ImplAdmin implements UserProfile {

  @Override
  public ProfileType type() {
    System.out.println("Access level: Admin");
    return ProfileType.ADMIN;
  }
}
