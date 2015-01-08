package Reflection;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liliya on 08/01/2015.
 */
public class MyClass {

    public static void main(String[] args) {
        System.out.print("Pretty: ");
        Scanner sc = new Scanner(System.in);
        String cl = sc.next();
        try {
            Class c = Class.forName(cl);        //a precise package name needs to be given
            Method[] methods = c.getMethods();  //getMethods returns all methods inherited and declaredMethods only the ones in the Class
            List<Method> listMethods = new ArrayList<>();
            for (int i = 0; i < methods.length; i++) {
                listMethods.add(methods[i]);
            }
            System.out.println("Methods that class "+ cl + " responds to are: ");
            listMethods.stream().forEach(s -> System.out.println(s)); //prints out all methods that a Random class responds to
        } catch (ClassNotFoundException ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }

    }

}
