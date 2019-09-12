import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFPage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileOutputStream;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Font;

import java.util.Arrays;

public class PDFFile extends GenPDF {
  // Manejador de documentos PDF.
  private static final PDFDocument PDF_DOCUMENT = new PDFDocument();
  // Diposición de las páginas.
  // (Hoja tamñano carta con márgenes de aprox. 2.5 cm).
  private static final double MARGIN = 1 * 72;
  private static final double PAGE_WIDTH = 8.5 * 72;
  private static final double PAGE_HEIGHT = 11 * 72;
  // Fuente.
  private static final Font FONT = new Font("Times New Roman", Font.PLAIN, 11);
  // Formato de páginas.
  private PageFormat PAGE_FORMAT;

  // Altura de escritura en la página.
  private double currentY;
  // Objeto para escritura.
  private Graphics2D graphics2D;

  public PDFFile(String nombre){
    super(nombre);
    this.prepararEscritura();
  }

  protected void prepararEscritura(){

    // ----Especificación de formato de la página----
    Paper paper = new Paper();
    paper.setSize(PAGE_WIDTH, PAGE_HEIGHT); // Tamaño de papel.

    // Defino región utilizable ajustada a toda la página.
    // Los márgenes serán respetados en el proceso de escritura.
    paper.setImageableArea(0, 0, PAGE_WIDTH, PAGE_HEIGHT);
    // Configuración de objeto de PageFormat con objeto de Paper.
    PageFormat pageFormat = new PageFormat();
    pageFormat.setPaper(paper);
    PAGE_FORMAT = pageFormat;

    // Primera página.
    addNewPage();
  }

  @Override
  public void createPDF(String[][] info){
    try {
        Files.deleteIfExists(Paths.get(nombre));
      }
      catch(IOException exception) {
        exception.printStackTrace();
        System.exit(1);
      }
      // Título del documento
      this.writeln("REPORTE DE CALIFICACIONES", Font.BOLD);
      this.writeln(""); // Espacio en blanco.

      // Encabezado de la tabla.
      String[] headers = {"MATRICULA", "ALUMNO", "CALIFICACION"};

      // Escribir tabla.
      this.writeTable(info, headers);

      // Guardar PDF.
      this.save();
  }


  public void writeln(String text, int fontType) {
    if(currentY > PAGE_HEIGHT - MARGIN)
      addNewPage();

    graphics2D.setFont(new Font(FONT.getName(), fontType, FONT.getSize()));

    // Obtener métricas de la fuente.
    // Información encapsulada en este objeto es útil en el proceso de escritura.
    FontMetrics fontMetrics = graphics2D.getFontMetrics();

    graphics2D.drawString(text, new Float(MARGIN), new Float(currentY));
    currentY += fontMetrics.getHeight();

    graphics2D.setFont(FONT);
  }

  public void writeln(String text) {
    if(currentY > PAGE_HEIGHT - MARGIN)
      addNewPage();

    // Obtener métricas de la fuente.
    // Información encapsulada en este objeto es útil en el proceso de escritura.
    FontMetrics fontMetrics = graphics2D.getFontMetrics();

    graphics2D.drawString(text, new Float(MARGIN), new Float(currentY));
    currentY += fontMetrics.getHeight();
  }

  public void writeTable(String[][] content, String[] headers) {
    double currentX = MARGIN;

    // Obtener métricas de la fuente.
    // Información encapsulada en este objeto es útil en el proceso de escritura.
    FontMetrics fontMetrics = graphics2D.getFontMetrics();

    double[] offsets = new double[headers.length];
    Arrays.fill(offsets, 0);

    for(int i = 0; i < headers.length; i++) {
      offsets[i] = offsets[i] > fontMetrics.bytesWidth(headers[i].getBytes(), 0, headers[i].getBytes().length)
        ? offsets[i] : fontMetrics.bytesWidth(headers[i].getBytes(), 0, headers[i].getBytes().length);
      for(int j = 0; j < content.length; j++)
        offsets[i] = offsets[i] > fontMetrics.bytesWidth(content[j][i].getBytes(), 0, content[j][i].getBytes().length)
        ? offsets[i] : fontMetrics.bytesWidth(content[j][i].getBytes(), 0, content[j][i].getBytes().length);
    }

    graphics2D.setFont(new Font(FONT.getName(), Font.ITALIC, FONT.getSize()));
    // Escribir encabezado de la tabla.
    for(int i = 0; i < headers.length; i++) {
      graphics2D.drawString(headers[i], new Float(currentX), new Float(currentY));
      currentX += offsets[i] + 30;
    }
    graphics2D.setFont(FONT);
    // Salto de línea.
    currentY += fontMetrics.getHeight();
    currentX = MARGIN;
    // Llenar tabla.
    for(int i = 0; i < content.length; i++) {
      for(int j = 0; j < content[0].length; j++) {
        graphics2D.drawString(content[i][j], new Float(currentX), new Float(currentY));
        currentX += offsets[j] + 30;
      }
      currentY += fontMetrics.getHeight();
      currentX = MARGIN;
      if(currentY > PAGE_HEIGHT - MARGIN)
        addNewPage();
    }
  }

  public boolean save() {
    boolean successStatus = true;

    try {
      Files.deleteIfExists(Paths.get(nombre));
      PDF_DOCUMENT.saveDocument(new FileOutputStream(nombre));
    }
    catch(IOException e) {
      successStatus = false;
    }

    return successStatus;
  }

  protected void addNewPage() {
    PDFPage pDFPage = PDF_DOCUMENT.createPage(PAGE_FORMAT);
    PDF_DOCUMENT.addPage(pDFPage);
    graphics2D = pDFPage.createGraphics();
    graphics2D.setFont(FONT);
    currentY = MARGIN;
  }
}
