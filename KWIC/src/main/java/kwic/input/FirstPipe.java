package kwic.input;

import java.util.Scanner;
import kwic.Filter;
import kwic.Pipe;

public class FirstPipe extends Pipe{
  
  private final Scanner reader;
 
  public FirstPipe(Filter filter, Scanner reader) {
    super(filter);
    this.reader = reader;
  }
 
  @Override
  public boolean canCallFilter(){
    return reader.hasNextLine();
  }
}
