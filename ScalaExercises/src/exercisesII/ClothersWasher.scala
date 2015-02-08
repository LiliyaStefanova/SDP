package exercisesII

/**
 * Created by liliya on 08/02/2015.
 */
class ClothersWasher(val modelName:String, val capacity:Double) {



  def this(modelName:String) = {this(modelName, 0) }

  def this(capacity:Double) = {this("placeholder", capacity)}


}

class ClothersWasher2(val modelName:String="placeholder", val capacity:Double=0)

