package kwic.input;

import kwic.Layer;
import kwic.separator.SeparatorFactory;

public abstract class Input extends Layer {
    public abstract String read();
    
    @Override
    public Layer nextLayer(){
        return SeparatorFactory.newSeparator();
    }
    
    @Override
    public Object doCurrentLayer(Object currentParam){
        return read();
    }
}
