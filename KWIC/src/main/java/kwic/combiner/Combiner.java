package kwic.combiner;

import kwic.Filter;
import kwic.sorter.SorterFactory;

public abstract class Combiner extends Filter {

  public abstract String[][] combine(String[] line);

  @Override
  public Filter nextLayer() {
    return SorterFactory.newSorter();
  }

  @Override
  public Object doCurrentLayer(Object currentParam) {
    return combine((String[]) currentParam);
  }
}
