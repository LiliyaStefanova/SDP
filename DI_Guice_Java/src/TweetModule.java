/**
 * Created by liliya on 16/02/2015.
 */
import com.google.inject.AbstractModule;

//an abstract module is extended to create an injector(TweetModule)
//the injector serves the goal of binding interfaces to the required implementations

public class TweetModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Tweeter.class).to(SmsTweeter.class);
        
        bind(Shortener.class).to(TinuUrlShortener.class);
    }
}
