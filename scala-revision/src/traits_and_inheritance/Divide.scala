package traits_and_inheritance

/**
 * Created by liliya on 20/04/2015.
 */

sealed trait DivisionResult {}

case class Finite(result:Int) extends DivisionResult

case class Infinite() extends DivisionResult

trait Maybe[A] {}

case class Full[A](result:A) extends Maybe[A]

case class EmptyResult[A]() extends Maybe[A]


//object divide extends App {
//
//  def apply(n: Int, d: Int): Maybe[Int] = {
//    d match {
//      case 0 => new EmptyResult[Int]()
//      case _ => new Full[Int](n / d)
//    }
//
//  }
//
//  println(divide(5, 2) match {
//    case Full(result) => s"The result is $result"
//    case EmptyResult() => "Infinite value"
//    case _ => throw new MatchError("Type not found")
//
//  })
//}

  object divideDouble extends App {

    def apply(n: Double, d: Double): Maybe[Double] = {
      d match {
        case 0 => new EmptyResult[Double]()
        case _ => new Full[Double](n / d)
      }

    }

    println( divideDouble(12.3, 2.5) match {
      case Full(result) => s"The result is $result"
      case EmptyResult() => "Infinite value"
      case _ => throw new MatchError("Type not found")

    })

}
  


 
  



