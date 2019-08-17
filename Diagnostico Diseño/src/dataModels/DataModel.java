package dataModels;

public abstract class DataModel {
    public abstract String[] toArray();
    public abstract void readFromArray(String[] data);
    
    protected int expectedColumns;
    public int expectedColumns(){
       return this.expectedColumns;
    }
}
