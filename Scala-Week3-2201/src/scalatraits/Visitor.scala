package traitClasses

import java.util.Date

/**
 * Created by liliya on 22/01/2015.
 */

sealed trait Visitor {
  def id:String
  def createdAt: Date
  def age: Long = new Date().getTime -createdAt.getTime //time a user has been a member
}
case class Anonymous(id:String, createdAt:Date = new Date()) extends Visitor{ //no implements

}

case class User(id:String,
                email:String,
                createdAt: Date = new Date()) extends Visitor{

      //override provides uniform access principle
      //age which was a function before has been overridden and turned to value
      override val age: Long = 15
}

object Testing{
  def main(args:Array[String]): Unit={
      println(Anonymous("anon1"))
      println(Anonymous("anon2"))
  }
}





