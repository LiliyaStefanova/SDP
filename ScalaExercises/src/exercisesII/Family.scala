package exercisesII



/**
 * Created by liliya on 08/02/2015.
 */
class Family(members: String*) {

  def familySize:Int = members.size
}

object Family{


  def main(args:Array[String])={
    val family1 = new Family("Mum", "Dad", "Sally", "Dick")
    println(family1.familySize)

    val family2 = new Family("Dad", "Mum", "Harry")
    println(family2.familySize)
  }
}
