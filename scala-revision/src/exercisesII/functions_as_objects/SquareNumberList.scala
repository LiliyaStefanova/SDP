package exercisesII.functions_as_objects
import exercisesII.AtomicTest._

/**
 * Created by liliya on 19/04/2015.
 */
object SquareNumberList extends App {

  var s = ""
  val numbers = Vector(1, 2, 5, 3, 7)
  numbers.foreach(x => s += (x * x).toString + " ")
  s is "1 4 25 9 49 "
}
