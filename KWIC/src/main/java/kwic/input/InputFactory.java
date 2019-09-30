package kwic.input;

public class InputFactory {

  public static Input newInput() {
    return new CommandLineInput();
  }
}
