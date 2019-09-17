package kwic;

import kwic.combiner.Combiner;
import kwic.combiner.CombinerFactory;
import kwic.input.Input;
import kwic.input.InputFactory;
import kwic.output.Output;
import kwic.output.OutputFactory;
import kwic.separator.Separator;
import kwic.separator.SeparatorFactory;
import kwic.sorter.Sorter;
import kwic.sorter.SorterFactory;

public class Kwic {
    private final Input input = InputFactory.newInput();
    private final Separator separator = SeparatorFactory.newSeparator();
    private final Combiner combiner = CombinerFactory.newCombiner();
    private final Sorter sorter = SorterFactory.newSorter();
    private final Output output = OutputFactory.newOutput();
    
    public void run(){
        String in = input.read();
        String[] sep = separator.separate(in);
        String[][] com = combiner.combine(sep);
        String[][] sorted = sorter.sort(com);
        output.write(sorted);
    }
    
    public static void main(String[] args){
        Kwic kwic = new Kwic();
        kwic.run();
    }
}
