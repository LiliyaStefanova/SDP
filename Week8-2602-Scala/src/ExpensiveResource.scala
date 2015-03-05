/**
 * Created by liliya on 26/02/2015.
 */
object ExpensiveResource extends App {
  
  //lazy does not evaluate until needed
  //var cannot be lazy as it will evaluated just the first time it is called
  lazy val resource:Int =init()
  
  def init():Int={
    //do something expensive
    println("Ouch")
    0
  
  }
  
  println(resource)

}
