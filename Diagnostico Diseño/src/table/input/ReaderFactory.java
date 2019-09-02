package table.input;

public class ReaderFactory {
    public static TableReader getReader(){
        return new XLSXReader();
    }
}
