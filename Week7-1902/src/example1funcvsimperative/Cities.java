package example1funcvsimperative;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liliya on 19/02/2015.
 */
public class Cities {
    
    public static void main(String [] args){
        
        List<String> cities= Arrays.asList("NYC", "Chicago", "Frankfurt");
        
        findCitiesImperative(cities, "Chicago");
        findCitiesFunctional(cities, "Chicago");
        
    }
    
    public static void findCitiesImperative(final List<String> cities, String name){
        boolean found = false;
        for(String city:cities){
            if(city.equals(name)){
                found=true;
                break;
            }
            
        }
       System.out.println("Found "+name + "?: "+ found);
    }
    
    public static void findCitiesFunctional(List<String> cities, String name){
        
        System.out.println("Found "+name + "?: "+cities.contains(name));
        
    }
}
