package kwic.output;

import kwic.Layer;

public abstract class Output extends Layer {
    public abstract void write(String[][] matrix);
    
    @Override
    public Layer nextLayer(){
        throw new UnsupportedOperationException("Not supported");
    }
    
    @Override
    public Object doCurrentLayer(Object currentParam){
        write((String[][]) currentParam);
        return null;
    }
}
