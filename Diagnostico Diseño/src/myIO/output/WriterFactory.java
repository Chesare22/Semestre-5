package myIO.output;

public class WriterFactory {
    public static TableWriter getWriter(){
        return new CSVWriter();
    }
}
