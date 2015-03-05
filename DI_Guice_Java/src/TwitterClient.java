import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Created by liliya on 16/02/2015.
 */
public class TwitterClient {
    
    TextField textField = new TextField();
    
    //Instead of worrying about creating the dependencies, just pass them in as part of the construct
    //holywood principle-don't call me, I'll call you
    @Inject         //annotation to specify that the dependencies are being injected. This completely removes the need for factories
    public TwitterClient(Shortener shortener, Tweeter tweeter){
        //other constructor code
        
    }
    
    public void postButtonClicked(){
        
        String text = textField.getText();
        
        if(text.length()>140){
            //indirect dependency
            Shortener shortener = ShortenerFactory.getShortener();
            text = shortener.shorten(text);
        }
        
        if(text.length()<=140){
            //indirect dependency
            Tweeter tweeter = TweeterFactory.getTweeter();
            tweeter.send(text);
            textField.clear();
        }
        
    }
    
    //These three lines of code bootstrap guice
    public static void main(String [] args){
        
        Injector injector = Guice.createInjector(new TweetModule());    //create the injector and pass it the module
        
        TwitterClient twitterClient = injector.getInstance(TwitterClient.class);    //get instance of the class you need to crete(i.e. reflection)
        
        twitterClient.show();   //run the class as required
        
    }
    
    public void show(){
        
        
    }

}
