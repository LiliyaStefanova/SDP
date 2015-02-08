package exercisesII

/**
 * Created by liliya on 08/02/2015.
 */
class TraditionalFamily(mother:String, father:String, children: String*) {

    def familySize:Int = 2 + children.size
  }

  object TraditionalFamily{


    def main(args:Array[String])={
      val family1 = new Family("Mum", "Dad", "Sally", "Dick")
      println(family1.familySize)

      val family2 = new Family("Dad", "Mum", "Harry")
      println(family2.familySize)
    }

}
