package classesandobjects

/**
 * Created by liliya on 31/01/2015.
 */

/*
The apply method is implemented in the companion object
 */
case class Person(firstName:String, lastName:String) {

  override def toString:String={
     firstName + " " + lastName
  }
}

object Person{

  def apply(fullName:String)={
    val part = fullName.split(" ")
    new Person(part(0), part(1))
  }

  def main(args:Array[String]):Unit={

    println(apply("John Doe").toString())
  }

}

