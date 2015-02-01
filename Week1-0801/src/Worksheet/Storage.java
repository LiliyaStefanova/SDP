package Worksheet;

/**
 * Created by liliya on 10/01/2015.
 */
public class Storage<T> {

    T x;

    public void setValue(T value){
        x = value;
    }

    public T getValue(){
        return x;
    }
}
