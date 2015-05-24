package some_more_exercises

/**
 * Created by liliya on 24/05/2015.
 */
//primary constructor with 3 params is part of the class
class Person(first_name: String, last_name: String, age: Int) {

  //auxilliary constructor with 1 param
  def this(firstName: String) = this(firstName, "", 0)

  //auxilliary constructor with 2 params
  def this(firstName: String, lastName: String) = this(firstName, lastName, 0)

}

object Person{

  val person1 = new Person("Liliya", "Stefanova", 29)
  val person2 = new Person("Liliya")
  val person3 = new Person("Liliya", "Stefanova")

}




