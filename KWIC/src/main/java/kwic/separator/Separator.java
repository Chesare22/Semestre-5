package kwic.separator;

import kwic.Layer;
import kwic.combiner.CombinerFactory;

public abstract class Separator extends Layer {
    public abstract String[] separate(String str);
    
    @Override
    public Layer nextLayer(){
        return CombinerFactory.newCombiner();
    }
    
    @Override
    public Object doCurrentLayer(Object currentParam){
        return separate((String) currentParam);
    }
}
