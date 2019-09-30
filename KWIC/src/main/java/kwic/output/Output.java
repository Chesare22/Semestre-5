package kwic.output;

import kwic.Filter;

public abstract class Output extends Filter {

  public abstract void write(String[][] matrix);

  @Override
  public Filter nextLayer() {
    throw new UnsupportedOperationException("Not supported");
  }

  @Override
  public Object doCurrentLayer(Object currentParam) {
    write((String[][]) currentParam);
    return null;
  }
}
