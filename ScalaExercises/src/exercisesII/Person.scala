package exercisesII

/**
 * Created by liliya on 08/02/2015.
 */
case class Person(firstName:String, lastName:String, email:String) {


}

object Person{

  def main(args:Array[String]):Unit={

    val p = Person("Jane", "Smile", "jane.smile@gmail.com")
    println(p.firstName)
    println(p.lastName)
    println(p.email)

    val people = Vector (
          Person("Jane", "Smile", "jane.smile@gmail.com"),
          Person("Ron", "House", "ron@house.com"),
          Person("Sally", "Dove", "sally.dove@hotmail.com")
    )

    println(people(0))
    println(people(1))
    println(people(2))
  }
}
