import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by liliya on 19/02/2015.
 */
public class PickNames {
    
    public static void main(String [] args){

        List<String> friends = Arrays.asList("Betty", "Bob", "James");

        //We can create Predicate and assign it to filter
        Predicate<String> startsWithB = name -> name.startsWith("B");
        friends.stream().filter(startsWithB).forEach(System.out::println);
        
        //or via lambda
        friends.stream().filter(name->name.startsWith("B")).forEach(System.out::println);
        
        //sum requires map to return a particular return type so need to call mapToInt
        friends.stream()
                .mapToInt(name->name.length())
                .sum();
        
       String s = friends.stream().reduce("Fred", (name1, name2)->(name1.length()>=name2.length()? name1 : name2));
        System.out.println("Which is longer:"+s);

        
    }
}
