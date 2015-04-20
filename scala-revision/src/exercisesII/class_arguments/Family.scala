package exercisesII.class_arguments

/**
 * Created by liliya on 18/04/2015.
 */
case class Family(famMembers:String*) { //variable number of arguments

  def familySize() = famMembers.size
}

object Family extends App{
  
  val family1 = new Family("Mum", "Dad", "Sally", "Dick")
  println(family1.familySize())
  
  val family2 = new Family("Dad", "Mom", "Harry")
  
  println(family2.familySize())
  
  val family3 = new FlexibleFamily("Mum", "Dad", "Sally", "Dick")
  println(family3.familySize())
  
  val family4 = new FlexibleFamily("Dad", "Mum", "Harry")
  println(family4.familySize())
  
}

case class FlexibleFamily(mum:String, dad:String, children:String*) { //variable number of arguments

  def familySize() = 2 + children.size
}


