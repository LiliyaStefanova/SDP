/**
 * Singleton is a creational pattern which is used to create a class which 
 * can only create a single object instance and not more
 * In Java this is accomplished by making the class constructor private, 
 * keeping an instance of the class as a static member in the object* 
 * and only exposing an an instance getter
 * 
 * public class SingleObject{
 *    private static SingleObject instance = new SingleObject();
 *    
 *    private SingleObject() {}
 *    
 *    public static SingleObject getInstance(){
 *    return instance;
 *    }
 *    In Scala all you have to do is use an object*    

 */

object SingleObject {
  
  def showMessage():String = "Hello world"
}

object AnotherObject extends App{
  
  SingleObject.showMessage()
  
}