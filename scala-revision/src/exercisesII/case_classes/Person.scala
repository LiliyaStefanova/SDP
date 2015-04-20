package exercisesII.case_classes

import exercisesII.AtomicTest._

/**
 * Created by liliya on 19/04/2015.
 */
case class Person(firstName: String, surname: String, contact: String) {

}

object Person extends App {

  val p = Person("Jane", "Smile", "jane@smile.com")
  p.firstName is "Jane"
  p.surname is "Smile"
  p.contact is "jane@smile.com"


  val people = Vector(
    Person("Jane", "Smile", "jane@smile.com"),
    Person("Ron", "House", "ron@house.com"),
    Person("Sally", "Dove", "sally@dove.com")
  )
  
  people(0).firstName is "Jane"
  people(1).surname is "House"
  people(2).contact is "sally@dove.com"
}
