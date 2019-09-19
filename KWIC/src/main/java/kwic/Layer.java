package kwic;

public abstract class Layer {
    
    public abstract Object doCurrentLayer(Object param);
    public abstract Layer nextLayer() throws UnsupportedOperationException;
    
    public void doLayersChain(Object currentParam){
        Object nextParam = doCurrentLayer(currentParam);
        try{
            nextLayer().doLayersChain(nextParam);
        }catch(UnsupportedOperationException ex) {}
    }
}
