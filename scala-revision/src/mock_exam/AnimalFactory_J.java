package mock_exam;

/**
 * Created by liliya on 16/04/2015.
 */
interface Animals {}

class Doggie implements  Animals{};

class Cattie implements Animals{};

public class AnimalFactory_J {
    
    public static Animals AnimalFactory_J(String type){
        if(type.equals("cat")) {return new Cattie();}
        else if(type.equals("dog")) { return new Doggie();}
        throw new IllegalArgumentException();
    }
}
