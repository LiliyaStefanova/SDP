package traits_and_inheritance

/**
 * Created by liliya on 10/05/2015.
 */
case class  PairTup[A, B](one:A, two:B) 

object PairTup extends App{
  
  val pair = PairTup[String, Int]("hi", 2)
  println(pair.one)
  println(pair.two)
  
}
