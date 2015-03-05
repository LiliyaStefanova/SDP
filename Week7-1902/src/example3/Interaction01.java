package example3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by liliya on 19/02/2015.
 */
public class Interaction01 {
    
    public static void main(String [] args){
        
        List<String> friends = Arrays.asList("Betty", "Bob", "James");
        
        //The shortest alternative is just to allow for static methods to be called directly
        //This is called a method reference
        
        friends.forEach(System.out::println);
        
        //The alternative is to implement a consumer as a separate class that implements consumer

        friends.forEach(new MyConsumer<>());
        
        //The other alternative is with anonymous inner class
        
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        
        //alternative with lambda expression
        //We can do this because the interface only has on default method to complete
        //Therefore Java infers this is the implementation of the accept method for the Consumer
        //the other method is default so Java 8 is not expecting it
        
        friends.forEach(s->System.out.println(s));
        
        friends.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        
        System.out.println(friends.stream().map(String::length)
                .count());
        
        friends.stream()
               .map(String::length)
                .forEach(count->System.out.println(count));
    }
    
    
}

class MyConsumer<T> implements Consumer<T>{

    @Override
    public void accept(T t) {
        System.out.println(t);
    }
}