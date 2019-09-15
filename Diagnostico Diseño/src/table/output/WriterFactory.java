package table.output;

public class WriterFactory {
    public static TableWriter getWriter(){
        return new PDFWriter();
    }
}
