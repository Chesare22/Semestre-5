package csv.input;

public class ReaderFactory {
    public static TableReader getReader(){
        return new CSVReader();
    }
}
