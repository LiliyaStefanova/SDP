package companion

/**
 * Created by liliya on 22/01/2015.
 */
class Person(val firstName:String, val lastName:String) {}

  object Person{

      def apply(fullName:String)={
        val parts = fullName.split(" ")
        new Person(parts(0), parts(1))

      }


  }


