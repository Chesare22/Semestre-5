package kwic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ResourceObserver implements MyObserver {
  
  AutoCloseable resource;
  
  public ResourceObserver(AutoCloseable resource){
    this.resource = resource;
  }

  @Override
  public void update() {
    try {
      resource.close();
    } catch (Exception ex) {
      Logger.getLogger(ResourceObserver.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
