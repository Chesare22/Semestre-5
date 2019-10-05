package kwic;

import java.io.File;
import java.io.IOException;

public interface FileObserver {
  public void openFile(File file) throws IOException;
  public void closeFile() throws IOException;
}
