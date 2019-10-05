package kwic.separator;

import kwic.Filter;

public abstract class Separator implements Filter {

  public abstract String[] separate(String str);

  @Override
  public Object doCurrent(Object currentParam) {
    return separate((String) currentParam);
  }
}
