package kwic.sorter;

class BubbleSorter extends Sorter {

  private String[][] matrix;

  @Override
  public String[][] sort(String[][] matrix) {
    this.matrix = matrix;
    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = i + 1; j < matrix.length; j++) {
        int k = 0;
        boolean sameValue;
        do {
          boolean valueAtIIsLessThanValueAtJ;
          try {
            valueAtIIsLessThanValueAtJ = matrix[j][k].toLowerCase().compareTo(matrix[i][k].toLowerCase()) < 0;
          } catch (IndexOutOfBoundsException ex) {
            //If one row is completely equal to another, then all are equal.
            return matrix;
          }
          if (valueAtIIsLessThanValueAtJ) {
            swapRow(i, j);
            sameValue = false;
          } else if (matrix[j][k].toLowerCase().equals(matrix[i][k].toLowerCase())) {
            k++;
            sameValue = true;
          } else {
            sameValue = false;
          }
        } while (sameValue);
      }
    }
    return matrix;
  }

  private void swapRow(int index1, int index2) {
    String[] aux = matrix[index1];
    matrix[index1] = matrix[index2];
    matrix[index2] = aux;
  }
}
