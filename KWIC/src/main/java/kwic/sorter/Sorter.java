package kwic.sorter;

import kwic.Filter;
import kwic.output.OutputFactory;

public abstract class Sorter extends Filter {

  /**
   * Sorts the matrix in alphabetical order according to all the elements.
   *
   * @param matrix
   * @return The matrix sorted.
   */
  public abstract String[][] sort(String[][] matrix);

  @Override
  public Filter nextLayer() {
    return OutputFactory.newOutput();
  }

  @Override
  public Object doCurrentLayer(Object currentParam) {
    return sort((String[][]) currentParam);
  }
}
