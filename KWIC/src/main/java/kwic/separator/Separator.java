package kwic.separator;

import kwic.Filter;
import kwic.combiner.CombinerFactory;

public abstract class Separator extends Filter {

  public abstract String[] separate(String str);

  @Override
  public Filter nextLayer() {
    return CombinerFactory.newCombiner();
  }

  @Override
  public Object doCurrentLayer(Object currentParam) {
    return separate((String) currentParam);
  }
}
