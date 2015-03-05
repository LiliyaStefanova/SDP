import java.util.Arrays;
import java.util.List;

/**
 * Created by liliya on 19/02/2015.
 */
public class PickFirst {
    
    public static void main(String [] args){


        List<String> friends = Arrays.asList("Betty", "Bob", "James", "Dodo", "Lala", "Johny");
        
        //Find first returns an Optional which allows for handling of null values as results
        System.out.println(friends.stream()
                                  .filter(name->name.startsWith("F"))
                                  .findFirst().orElse("no names found"));
        
        System.out.println(friends.stream()
                                  .filter(name->name.startsWith("J"))
                                  .findFirst().orElse("no names found"));


    }
    
    //Checkout tail call

    
}
