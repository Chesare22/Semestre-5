package kwic;

public interface Filter {

  /**
   * Ejecuta el filtro actual y la tubería al siguiente (si tiene).
   *
   * @param param
   */
  public void doCurrent(Object param);

}
