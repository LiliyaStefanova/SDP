package sealedtraits

/**
 * Created by liliya on 29/01/2015.
 */
sealed trait DivisionResult

final case class Finite(value:Int) extends DivisionResult

final case object Infinite extends DivisionResult


  //divide(1, 2) => Finite(0)
  //divide(2, 1) => Finite(2)
  //divide(1, 0) => Infinite

object Divide {
  def apply(numerator:Int, denominator:Int)={
    if(denominator==0) Infinite else Finite(numerator/denominator)
  }
}

object Test extends  App{
  Divide.apply(1, 0) match {
    case Finite (value)=>s"It's finite: ${value}"
    case Infinite => "It's infinite"
  }
}
