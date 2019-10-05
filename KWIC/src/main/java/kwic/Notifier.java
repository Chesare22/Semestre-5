package kwic;

import java.util.ArrayList;

public class Notifier {

  private final ArrayList<MyObserver> observers = new ArrayList<>();

  public void updateAll() {
    observers.forEach((observer) -> {
      observer.update();
    });
  }

  public void addObserver(MyObserver observer) {
    observers.add(observer);
  }
}
