@Profile(ProfileType.ADMIN)
public class ImplAdmin implements UserProfile {

  @Override
  public ProfileType type() {
    System.out.println("Access level: Admin");
    return ProfileType.ADMIN;
  }
}
