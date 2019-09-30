package kwic.sorter;

public class SorterFactory {

  public static Sorter newSorter() {
    return new BubbleSorter();
  }
}
