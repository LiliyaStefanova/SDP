package example1funcvsimperative;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liliya on 19/02/2015.
 */
public class Discount {
    
    public static void main(String [] args){
        
        final List<Integer> prices = Arrays.asList(10, 15, 20, 25);
        
        System.out.println("Total of discounted prices: " + discountImperative(prices));
        
        //functional
         System.out.println("Total of discounted prices: " + discountFunctional(prices));
    }
    
    static Double discountImperative(List<Integer> prices){
        
        Double totalOfDiscountedPrices = 0.0;
        for(Integer item: prices){
            totalOfDiscountedPrices+= item*0.9;
        }
        
        return totalOfDiscountedPrices;
        
    }

    static Double discountFunctional(List<Integer> prices){

       return (prices
               .stream()
               .mapToDouble(price -> price * 0.9)
               .sum());

    }


}
