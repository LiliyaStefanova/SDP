/**
 * Created by liliya on 16/02/2015.
 */
public class ShortenerFactory {
    
    public static Shortener getShortener(){
        
        return new TinuUrlShortener();
        
    }
}
