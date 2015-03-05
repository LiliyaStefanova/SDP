package example2inheritance;

/**
 * Created by liliya on 19/02/2015.
 */
public interface B extends A {
    
    public default String eats(){
        return "Sometimes I eat";
        
    }
}
