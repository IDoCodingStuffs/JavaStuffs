@Profile(ProfileType.OPERATOR)
public class ImplOperator implements UserProfile {

  @Override
  public ProfileType type() {
    System.out.println("Access level: Operator");
    return ProfileType.OPERATOR;
  }
}
