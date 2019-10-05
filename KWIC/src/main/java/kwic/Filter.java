package kwic;

public interface Filter {

  public Object doCurrent(Object param);

  public Pipe getPipeToNextFilter();

}
