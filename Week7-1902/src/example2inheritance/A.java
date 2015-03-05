package example2inheritance;

/**
 * Created by liliya on 19/02/2015.
 */
public interface A {
    
    //Interfaces in Java allow for interfaces to provide method implementations providing the default keyword
    public  default String eats(){
        return "I do eat";
        
    }
    
    public default void anotherOne(){
        ////
        
    }
}
