package kwic.separator;

public class SeparatorFactory {

  public static Separator newSeparator() {
    return new WhitespaceSeparator();
  }
}
