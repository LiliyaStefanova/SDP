package caseclasses

/**
 * Created by liliya on 22/01/2015.
 */
object Test {
   def main(args:Array[String])={
     val p = new Person("Philip", "Schol")
     val p1= new Person("Philip", "Schol")
     println(p)
     println(p1)
     println(p.equals(p1))   //different memory reference
     println(p==p1)    //different memory reference not equal
     println(p eq p1)

     val p2=p1.copy()

     println(p1 equals(p2))
   }
 }
