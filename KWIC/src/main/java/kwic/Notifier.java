package kwic;

import java.util.ArrayList;

public class Notifier {

  private final ArrayList<Observer> observers = new ArrayList<>();

  public void notifyAllInstances() {
    observers.forEach((observer) -> {
      observer.update();
    });
  }

  public void attach(Observer observer) {
    observers.add(observer);
  }
}
