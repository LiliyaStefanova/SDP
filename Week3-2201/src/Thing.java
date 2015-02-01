/**
 * Created by liliya on 22/01/2015.
 */
//multiple inheritance using interfaces

public interface Thing{

    public default boolean alive(){
        return false;
    }
}

interface Fly extends Thing{
    public String eat();
}

interface Person extends Thing{
    public String eat();
}

interface Huly extends Fly, Person{

}

class FlyImpl implements Fly{

    @Override
    public String eat() {
        return "Bla Bla Bla";
    }

    //This implementation overrides the default implementation of the alive method in Thing
    @Override
    public boolean alive() {
        return true;
    }
}

class PersonImpl implements Person{

    @Override
    public String eat() {
        return "Lalalala";
    }

}

class HulyImpl extends PersonImpl implements Huly{

   //can't extend both so have private impls

    private PersonImpl pi;
    //default implementation of alive will be run

    @Override
    public String eat() {
        return pi.eat();
    }

    //Instead of multiple inheritance we are having to do composition to access the individual implementations
}

