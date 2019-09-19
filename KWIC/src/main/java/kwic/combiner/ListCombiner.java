package kwic.combiner;

import static com.google.common.collect.Lists.newArrayList;
import java.util.List;

class ListCombiner extends Combiner{

    @Override
    public String[][] combine(String[] line) {
        String[][] combinations = new String[line.length][];
        List<String> list = newArrayList(line);
        
        for(int i = 0; i<line.length; i++){
            combinations[i] = list.toArray(new String[line.length]);
            list.add(list.remove(0));
        }
        
        return combinations;
    }
    
}
