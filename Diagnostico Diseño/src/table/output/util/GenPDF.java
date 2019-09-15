package table.output.util;

public abstract class GenPDF{
  protected String[] encabezado;
  protected String nombre;

  public GenPDF(String nombre){
    this.nombre = nombre;
  }

  public abstract void createPDF(String[][] info);

  public void setEncabezado(String[] encabezado){this.encabezado = encabezado;}

  public String[] getEncabezado(){return encabezado;}

  public void setNombre(String nombre){this.nombre = nombre;}

  public String getNombre(){return nombre;}
}
