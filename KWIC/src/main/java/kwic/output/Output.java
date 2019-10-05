package kwic.output;

import java.io.File;
import kwic.Filter;

public abstract class Output implements Filter {

  public abstract void write(String[][] matrix);
  public abstract void openFile(File file);
  public abstract void closeFile();
  
  @Override
  public void doCurrent(Object currentParam) {
    write((String[][]) currentParam);
  }
}
