package kwic.input;

import kwic.Filter;
import kwic.separator.SeparatorFactory;

public abstract class Input extends Filter {

  public abstract String read();

  @Override
  public Filter nextLayer() {
    return SeparatorFactory.newSeparator();
  }

  @Override
  public Object doCurrentLayer(Object currentParam) {
    return read();
  }
}
