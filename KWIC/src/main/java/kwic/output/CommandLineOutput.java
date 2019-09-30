package kwic.output;

class CommandLineOutput extends Output {

  @Override
  public void write(String[][] matrix) {
    for (String[] row : matrix) {
      System.out.println("");
      for (String field : row) {
        System.out.print(field + " ");
      }
    }
  }
}
