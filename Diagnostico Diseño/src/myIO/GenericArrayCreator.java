/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myIO;

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
