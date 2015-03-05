package example2inheritance;

/**
 * Created by liliya on 19/02/2015.
 */
public interface C extends B {
    
    public default String eats(){
        return "I eat all the time";
        
    }
}
