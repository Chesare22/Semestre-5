package model;

public class Candidate {

  private final int id;
  private final String name;

  public Candidate(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int id() {
    return id;
  }

  public String name() {
    return name;
  }
}
