package Reflection;

/**
 * Created by liliya on 08/01/2015.
 */
public class Person {

    private String name;
    private String userID;

    public Person(String n, String u){
        this.name = n;
        this.userID = u;
    }

    public Person(){
        this("Fred", "1234xyz");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    @Override
    public String toString(){
        return "Name: "+getName() + "|"+"User id: "+getUserID();
    }
}
