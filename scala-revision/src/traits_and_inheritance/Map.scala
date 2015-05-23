package traits_and_inheritance

/**
 * Created by liliya on 13/05/2015.
 */
object TestMap extends App{

  val myMap = Map("MI"->"Michigan", "OR"->"Oregon")

  val myMap1 = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")
  
  println(myMap1.head)
  println(myMap1.tail)
}
