/**
 * Created by liliya on 16/02/2015.
 */
public class TinuUrlShortener implements Shortener {


    @Override
    public String shorten(String text) {
        return text.trim();
    }
}
