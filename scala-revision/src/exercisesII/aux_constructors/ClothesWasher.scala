package exercisesII.aux_constructors
import exercisesII.AtomicTest._

/**
 * Created by liliya on 19/04/2015.
 */
class ClothesWasher {

  var modelName: String = ""
  var capacity: Double = 0.0

  def this(modelName: String) {
    this()
    this.modelName = modelName
  }

  def this(capacity: Double) {
    this()
    this.capacity = capacity

  }

}

//Need to make this a case class otherwise the object has no access to member vars
case class ClothesWasher2(modelName:String, capacity:Double){
  
}

object ClothesWasher extends App{
  
  val washer = new ClothesWasher("Bosch")
  val washer2 = new ClothesWasher(45.89)
  
  washer.capacity is 0.0
  washer.modelName is "Bosch"
  washer2.capacity is 45.89
  
  val washer3 = new ClothesWasher2("Samsung", 56.00)
  washer3.modelName is "Samsung"
  washer3.capacity is 56.00
  
}
