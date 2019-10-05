package kwic.input;

import kwic.Filter;
import kwic.Pipe;

public abstract class Input implements Filter {
  
  private final Pipe nextPipe;
  
  public Input(Pipe nextPipe) {
    this.nextPipe = nextPipe;
  }

  public abstract String readLine();
  
  @Override
  public Object doCurrent(Object param) {
    return readLine();
  }
  
  @Override
  public Pipe getPipeToNextFilter(){
    return nextPipe;
  }
}
