package table;

import java.lang.reflect.Array;

public class GenericArrayCreator<T> {
    private T[] array;
    Class<T> cls;
    public GenericArrayCreator(Class<T> cls){
        this.cls = cls;
    }
    
    public T[] create(int length){
        return (T[])Array.newInstance(cls, length);
    }
}
