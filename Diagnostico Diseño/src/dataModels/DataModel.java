package dataModels;

public interface DataModel {
    public abstract String[] toArray();
    public abstract void readFromArray(String[] data);
    public abstract int expectedColumns();
    public abstract String[] header();
}
