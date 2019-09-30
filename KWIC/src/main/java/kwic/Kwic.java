package kwic;

import kwic.input.InputFactory;

public class Kwic {
    
    private final Filter firstLayer = InputFactory.newInput();
    
    public void run(String[] args){
        firstLayer.doLayersChain(args);
    }
    
    public static void main(String[] args){
        Kwic kwic = new Kwic();
        kwic.run(args);
    }
}
