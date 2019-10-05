package kwic;

public class Pipe {
  
  private final Filter filter;
  
  public Pipe(Filter filter){
    this.filter = filter;
  }

  public void callFilter(Object param){
    Object nextParam = filter.doCurrent(param);
    
    Pipe nextPipe  = filter.getPipeToNextFilter();
    if(nextPipe != null && nextPipe.canCallFilter()) {
      nextPipe.callFilter(nextParam);
    }
  }

  // This method is intended to be overwriten
  public boolean canCallFilter() {
    return true;
  }
}
