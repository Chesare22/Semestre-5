package kwic.input;

import java.util.Scanner;

class CommandLineInput extends Input {

  @Override
  public String readLine() {
    System.out.println("Ingrese una sentencia:");

    Scanner reader = new Scanner(System.in);
    String input = reader.nextLine();
    reader.close();
    return input;
  }
}
