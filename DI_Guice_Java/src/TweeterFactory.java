/**
 * Created by liliya on 16/02/2015.
 */
public class TweeterFactory {
    
    private static Tweeter testValue;
    
    public static Tweeter getTweeter(){
        return new SmsTweeter();
        
    }
}
