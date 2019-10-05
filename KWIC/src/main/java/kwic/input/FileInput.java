package kwic.input;

import java.util.Scanner;

class FileInput extends Input {
  
  private final Scanner reader;
  
  public FileInput(Scanner reader) {
    this.reader = reader;
  }

  @Override
  public String readLine(){
     return reader.nextLine();
  }
}
