package kwic.combiner;

public class CombinerFactory {
    public static Combiner newCombiner(){
        return new ListCombiner();
    }
}
