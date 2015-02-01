package caseclasses

/**
  * Created by liliya on 22/01/2015.
  */
object Stormtrooper {

   def inspect(person:Person):String = {   //??? allows for the class to compile -returns any

     person match {
       case Person("Luke", "Skywalker") =>
         "bla bla bla"
       case Person("Jow", "Boggs")=>
         "lalalalala"
       case Person(first, name) =>
         s"Move along $first"
     }

     //compare if the person is someone specified

     //  if (person.firstName == new Person("Luke", "Skywalker"))
     //      "Stop, rebel scum!"
     //  else if ///
   }


 }
