package traits_and_inheritance

/**
 * Created by liliya on 20/04/2015.
 */

sealed trait DivisionResult {}

case class Finite(result:Int) extends DivisionResult

class Infinite extends DivisionResult


object divide {

  def apply(n: Int, d: Int): DivisionResult = {
    d match {
      case 0 => new Infinite
      case _ => new Finite(n / d)

    }
    divide(1, 2)

  }

//  def divideAndConquer(n:Int, d:Int) = divide(n, d) match {
//   // case Finite => "The result is "
//
//  }
}

 
  



