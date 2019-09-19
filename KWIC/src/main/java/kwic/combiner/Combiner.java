package kwic.combiner;

import kwic.Layer;
import kwic.sorter.SorterFactory;

public abstract class Combiner extends Layer {
    public abstract String[][] combine(String[] line);
    
    @Override
    public Layer nextLayer(){
        return SorterFactory.newSorter();
    }
    
    @Override
    public Object doCurrentLayer(Object currentParam){
        return combine((String[]) currentParam);
    }
}
