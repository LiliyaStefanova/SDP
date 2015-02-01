package sealedtraits

import java.util.Date

/**
 * Created by liliya on 29/01/2015.
 */

//sealed trait will not allow objects to be created if all of the cases have not been dealt with
sealed trait Visitor {

  def id:String
  def createdAt: Date
  def age: Long = new Date().getTime - createdAt.getTime

}
//sealed final final is a common pattern used in Scala
final case class Anonymous(id:String, createdAt:Date) extends Visitor{}

//case class gives us getter, setter, equals, hash code
final case class User(id:String,
                email:String,
                createdAt:Date = new Date()
                 ) extends Visitor

object Thing extends App{
  def missing(v:Visitor) =
  v match{
    case User(_,_,_) => "a users"
  }
}