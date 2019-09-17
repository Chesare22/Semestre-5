package kwic.output;

public class OutputFactory {
    public static Output newOutput(){
        return new CommandLineOutput();
    }
}
