package traits_and_inheritance

/**
 * Created by liliya on 10/05/2015.
 */
trait Sum[A, B]{}

case class Left[A, B](value:A) extends Sum[A, B]

case class Right[A, B](value:B) extends Sum[A, B]

object SumTest extends App {
  
  Left[Int, String](1).value
  
  Right[Int, String]("foo").value
  
  val sum:Sum[Int, String] = Right("foo")
  
  sum match {
    case Left(x) => println(x.toString)
    case Right(x) => println(x)
  }
  
}