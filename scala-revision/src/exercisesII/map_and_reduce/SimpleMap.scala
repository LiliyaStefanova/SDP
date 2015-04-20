package exercisesII.map_and_reduce

import exercisesII.AtomicTest._
/**
 * Created by liliya on 19/04/2015.
 */
object SimpleMap extends App {

  val v = Vector(1, 2, 3, 4)
  //v.map(n => n*11 + 10) is Vector(21, 32, 43, 54)

  //Empty vector is returned if using foreach because it does not persist the result of the function - only applies is on the fly?
  //v.foreach(n=>n*11+10) is Vector(21, 32, 43, 54)


  def convert(v: Vector[Int]) = {
    var temp = Vector[Int]()
    for (i <- v) {
     temp = temp :+  (i*11) + 10
    }
    temp
  }

  convert(v) is Vector(21, 32, 43, 54)


}